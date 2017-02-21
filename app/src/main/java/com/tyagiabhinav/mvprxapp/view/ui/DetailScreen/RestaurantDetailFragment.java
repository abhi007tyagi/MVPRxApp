/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.view.ui.DetailScreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.R;
import com.tyagiabhinav.mvprxapp.model.Injection;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;
import com.tyagiabhinav.mvprxapp.util.Constants;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainActivity;

import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment representing a single Restaurant detail screen.
 * This fragment is either contained in a {@link MainActivity}
 * in two-pane mode (on tablets) or a {@link RestaurantDetailActivity}
 * on handsets.
 */
public class RestaurantDetailFragment extends Fragment implements DetailContract.View {

    public static final String TAG = RestaurantDetailFragment.class.getSimpleName();
    private static final int REVIEW_ACTION = 900;
    private boolean mTwoPane = false;
    private DetailContract.Presenter presenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantDetailFragment() {
    }

    private Restaurant mRestaurant;

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout appBarLayout;

    @BindView(R.id.foodImg)
    ImageView img;

    @BindView(R.id.address)
    TextView address;

    @BindView(R.id.phone)
    TextView phone;

    @BindView(R.id.website)
    TextView website;

    @BindView(R.id.tips)
    TextView tips;

    @BindView(R.id.review)
    TextView review;

    @BindView(R.id.isOpen)
    ImageView isOpen;

    @BindView(R.id.priceTier)
    TextView priceTier;

    @BindView(R.id.distance)
    TextView distance;

    @BindView(R.id.rating)
    TextView rating;

    @Inject
    Picasso picasso;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get arguments passed from activity
        if (getArguments().containsKey(Constants.SELECTED_RESTAURANT)) {
            mRestaurant = getArguments().getParcelable(Constants.SELECTED_RESTAURANT);
            mTwoPane = getArguments().getBoolean(Constants.TWO_PANE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaurant_detail, container, false);
        ButterKnife.bind(this, rootView);
        MVPRxAPP.getAppComponent().inject(this);

        presenter = new DetailPresenter(this, Injection.provideRestaurantRepo(getActivity().getApplicationContext()));

        if (!mTwoPane) {
            // set toolbar for single pane
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        } else {
            // else hide toolbar
            toolbar.setVisibility(View.GONE);
        }
        // set up home button in case of single pane
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(!mTwoPane);

        // check if obj is not null
        if (mRestaurant != null) {

            // set ui.. if data is present, populate related view else hide it
            if (mRestaurant.getAddress() != null && !TextUtils.isEmpty(mRestaurant.getAddress())) {
                address.setText(mRestaurant.getAddress());
            } else {
                address.setVisibility(View.GONE);
            }

            if (mRestaurant.getPhone() != null && !TextUtils.isEmpty(mRestaurant.getPhone())) {
                phone.setText(mRestaurant.getPhone());
            } else {
                phone.setVisibility(View.GONE);
            }

            if (mRestaurant.getUrl() != null && !TextUtils.isEmpty(mRestaurant.getUrl())) {
                website.setText(mRestaurant.getUrl());
            } else {
                website.setVisibility(View.GONE);
            }

            if (mRestaurant.getTips() != null && !TextUtils.isEmpty(mRestaurant.getTips())) {
                tips.setText(mRestaurant.getTips());
            } else {
                tips.setVisibility(View.GONE);
            }

            if (mRestaurant.getComments() != null && !TextUtils.isEmpty(mRestaurant.getComments())) {
                review.setText(mRestaurant.getComments());
            } else {
                review.setVisibility(View.GONE);
            }

            if (mRestaurant.isOpen()) {
                isOpen.setImageResource(R.drawable.green_dot);
            } else {
                isOpen.setImageResource(R.drawable.yellow_dot);
            }

            DecimalFormat df = new DecimalFormat("#.##");
            distance.setText(Float.valueOf(df.format(mRestaurant.getDistance())) + "km");

            rating.setText(mRestaurant.getRating() + "/10");

            int price = mRestaurant.getPrice();

            StringBuilder priceIcons = new StringBuilder();
            for (int i = 0; i < price; i++) {
                priceIcons.append("$");
            }
            priceTier.setText(priceIcons.toString());

            if (appBarLayout != null) {
                appBarLayout.setTitle(mRestaurant.getName());
                picasso.load(mRestaurant.getImgUrl())
                        .into(img);
            }
        }
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case REVIEW_ACTION:

                if (resultCode == Activity.RESULT_OK) {
                    // After Ok code.
                    Log.d(TAG, "onActivityResult: OK");
                    String reviewComment = intent.getStringExtra(Constants.REVIEW_COMMENT);
                    if (reviewComment != null && !TextUtils.isEmpty(reviewComment)) {
//                        NetworkUtils.reviewAction(mRestaurantId, reviewComments);
                        presenter.onReview(mRestaurant.getId(), reviewComment);
                        review.setText(reviewComment);
                        review.setVisibility(View.VISIBLE);
                        mRestaurant.setComments(reviewComment);
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    // After Cancel code.
                    Log.d(TAG, "onActivityResult: CANCEL");
                }
                break;
        }
    }

    /**
     * set fab listener to start navigation to selected restaurant using google maps
     */
    @OnClick(R.id.fab)
    public void navigate() {
        Log.d(TAG, "navigate: ");
        if (mRestaurant != null) {
            String navURL = "";
            String lat = Double.toString(mRestaurant.getLat());
            String lon = Double.toString(mRestaurant.getLon());
            if (!TextUtils.isEmpty(lat) && !TextUtils.isEmpty(lon)) {
                navURL = "http://maps.google.com/maps?f=d&source=s_d&daddr=" + lat + "," + lon + "&hl=zh&t=m&dirflg=d";
            } else if (mRestaurant.getAddress() != null && !TextUtils.isEmpty(mRestaurant.getAddress())) {
                navURL = "http://maps.google.com/maps?f=d&source=s_d&daddr=" + mRestaurant.getAddress() + "&hl=zh&t=m&dirflg=d";
            }
            Log.d(TAG, "NAV_URL-->" + navURL);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(navURL));
            mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

            // Verify it resolves
            PackageManager packageManager = getActivity().getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            // Start an activity if it's safe
            if (isIntentSafe) {
                startActivity(mapIntent);
            } else {
                Toast.makeText(getActivity(), getString(R.string.get_google_map), Toast.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(appBarLayout, getString(R.string.navigation_unavailable), Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }

    /**
     * set click listener for phone call using implicit intent
     */
    @OnClick(R.id.phone)
    public void call() {
        Log.d(TAG, "calling..");
        String phoneNo = phone.getText().toString().replaceAll("-", "");
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNo)));
    }

    /**
     * set click listener for like button
     */
    @OnClick(R.id.upBtn)
    public void upAction() {
        Log.d(TAG, "you liked it..");
//        NetworkUtils.doUpAction(mRestaurant.getId());
        presenter.onActionUp(mRestaurant.getId());
        ReviewFragment reviewFragment = new ReviewFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.SELECTED_RESTAURANT_ID, mRestaurant.getId());
//        reviewFragment.setArguments(bundle);
        reviewFragment.setTargetFragment(this, REVIEW_ACTION);
        reviewFragment.show(getActivity().getSupportFragmentManager(), null);


    }

    /**
     * set click listener for dislike button
     */
    @OnClick(R.id.downBtn)
    public void downAction() {
        Log.d(TAG, "you disliked it..");
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        // Setting Dialog Message
        alertDialog.setMessage(getString(R.string.down_action_alert_msg));

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
//                NetworkUtils.doDownAction(mRestaurant.getId());
                presenter.onActionDown(mRestaurant.getId());
                Toast.makeText(getActivity(), getString(R.string.down_action_yes_msg), Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    @Override
    public void updateView(Restaurant restaurant) {

    }
}
