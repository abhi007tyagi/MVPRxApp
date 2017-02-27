package com.tyagiabhinav.mvprxapp.view.ui.MainScreen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.R;
import com.tyagiabhinav.mvprxapp.model.Injection;
import com.tyagiabhinav.mvprxapp.model.LoaderProvider;
import com.tyagiabhinav.mvprxapp.model.RestaurantValues;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;
import com.tyagiabhinav.mvprxapp.util.DividerLine;
import com.tyagiabhinav.mvprxapp.util.NetworkUtils;
import com.tyagiabhinav.mvprxapp.util.PrefHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View , GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {


    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int LOCATION_PERMISSION = 279;

    private MainPresenter presenter;

    private boolean mTwoPane;

    private GoogleApiClient mGoogleApiClient;

    private boolean askEnableGPS = false;

    private int mSortOrder = SortOrder.DEFAULT;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.restaurant_list)
    RecyclerView mRecyclerView;

    @Inject
    PrefHelper mPrefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            isLocationPermissionGranted();
        }

        ButterKnife.bind(this);
        MVPRxAPP.getAppComponent().inject(this);

        if (findViewById(R.id.restaurant_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: toolbar set");
        toolbar.setTitle(getTitle());

        // to improve performance as changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        int numColumns = 2;

        // use grid layout manager for positioning of items in the list in grid formation
        final RecyclerView.LayoutManager restaurantLayoutManager = new GridLayoutManager(MainActivity.this, numColumns);
        mRecyclerView.setLayoutManager(restaurantLayoutManager);
        mRecyclerView.addItemDecoration(new DividerLine(this));

        // Create the presenter
        LoaderProvider loaderProvider = new LoaderProvider(this);

        presenter = new MainPresenter(this, loaderProvider, getSupportLoaderManager(), Injection.provideRestaurantRepo(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // initialize loader if network is not available to show saved data
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            if (askEnableGPS) {
                askEnableGPS = false;
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    onLocationChanged(LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient));
                }
            } else {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    LocationRequest mLocationRequest = new LocationRequest();
                    mLocationRequest.setInterval(1800000); // 30 mins regular update interval
                    mLocationRequest.setFastestInterval(600000); // 10 mins fastest update interval
                    mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    mLocationRequest.setSmallestDisplacement(1000); // 1km distance for update
                    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
                }
            }
        }

        if (!NetworkUtils.isNetworkConnectionAvailable()) {
            Toast.makeText(this, "Network not available.\nShowing saved data!", Toast.LENGTH_SHORT).show();
//            getSupportLoaderManager().initLoader(CURSOR_LOADER, null, this);
            Bundle bundle = new Bundle();
            bundle.putInt(presenter.SORT_KEY, mSortOrder);
            presenter.getData(bundle);
        }

    }

    @Override
    protected void onPause() {
        Log.d(TAG, "on pause");
        super.onPause();
        //stop location updates when Activity is no longer active
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == LOCATION_PERMISSION) {
            Log.v(TAG, "Permission: " + permissions[0] + " was " + grantResults[0]);
            //resume tasks needing this permission
            buildGoogleApiClient();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    /**
     * Check if permission is granted
     *
     * @return
     */
    public boolean isLocationPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted 1");
                if (mGoogleApiClient != null) {
                    onLocationChanged(LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient));
                } else {
                    buildGoogleApiClient();
                }
                return true;
            } else {
                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION);
                return false;
            }
        } else {
            //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted <23");
            buildGoogleApiClient();
            return true;
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "on connected");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            onLocationChanged(LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {
        // check if last location change was more than 10 mins or not
        if ((System.currentTimeMillis() - mPrefHelper.getLastLocationUpdateTime()) > 10){//600000) {
            if (location == null) {
                Log.d(TAG, "Location Change");
                askEnableGPS = true;
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));//, ENABLE_GPS_REQUEST);
            } else {//if(!RestaurantListAdapter.isNextScreen){
                if (location.getAccuracy() < 200) {
                    Log.d(TAG, "Location Change --> " + location.getLatitude() + "|" + location.getLongitude());
                    //stop location updates
                    String mLat = String.valueOf(location.getLatitude());
                    String mLon = String.valueOf(location.getLongitude());

                    mPrefHelper.setCurrentLatitude(mLat);
                    mPrefHelper.setCurrentLongitude(mLon);

                    if (NetworkUtils.isNetworkConnectionAvailable()) {
//                        NetworkUtils.geRestaurants(this, NetworkUtils.getURL());
                        presenter.onLocationChanged();
                    }

                    mPrefHelper.setLastLocationUpdateTime(System.currentTimeMillis());
                    askEnableGPS = false;
                    if (mGoogleApiClient != null) {
                        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
                    }
                } else {
                    Log.d(TAG, "onLocationChanged: accuracy > 200");
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu.... ");
        getMenuInflater().inflate(R.menu.list_menu, menu);

        // search restaurants that serve food items as per search query e.g. burger, pizza
        // search functionality implementation
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.onActionViewCollapsed();
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle Search Query
                Log.d(TAG, "onQueryTextSubmit: " + query);
                try {
                    mPrefHelper.setCuisineType(URLEncoder.encode(query, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (NetworkUtils.isNetworkConnectionAvailable()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(presenter.SORT_KEY, mSortOrder);
                    presenter.getData(bundle);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        // sort/filter restaurants in order as per option selected by user
        // drop-down spinner implementation
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(menu.findItem(R.id.action_spinner));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sort_option, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.menu_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSortOrder = position;
                Bundle bundle = new Bundle();
                bundle.putInt(presenter.SORT_KEY, mSortOrder);
                presenter.getData(bundle);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return true;
    }



    @Override
    public void updateView(Cursor cursor){//List<Restaurant> restaurants) {
        List<Restaurant> restaurants = RestaurantValues.getRestaurantsFromCursor(cursor);
        if (mRecyclerView != null) {
            Log.d(TAG, "setupRecyclerView: ");
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mTwoPane, restaurants);
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        if (restaurants.size() < 1) {
            Snackbar.make(mRecyclerView, getString(R.string.no_nearby_restaurants), Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }

}
