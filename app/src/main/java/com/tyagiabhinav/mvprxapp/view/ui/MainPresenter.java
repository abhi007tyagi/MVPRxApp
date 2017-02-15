package com.tyagiabhinav.mvprxapp.view.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.model.DataSource;
import com.tyagiabhinav.mvprxapp.model.LoaderProvider;
import com.tyagiabhinav.mvprxapp.model.RestaurantSource;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public class MainPresenter implements MainContract.Presenter, LoaderManager.LoaderCallbacks<Cursor>, DataSource.GetRestaurantList{

    public static final String TAG = MainPresenter.class.getSimpleName();

    public static final int TASKS_LOADER = 27;
    public static final String SORT_KEY = "sort_key";

    private final MainContract.View view;
    private final LoaderProvider mLoaderProvider;
    private final LoaderManager mLoaderManager;
    private final RestaurantSource mRestaurantSource;

    private int mSortOrder = SortOrder.DEFAULT;

    public MainPresenter(MainContract.View view, LoaderProvider loaderProvider, LoaderManager loaderManager, RestaurantSource restaurantSource) {
        this.view = view;
        this.mLoaderProvider = loaderProvider;
        this.mLoaderManager = loaderManager;
        this.mRestaurantSource = restaurantSource;
    }

    @Override
    public void getData(int sortOrder) {
        this.mSortOrder = sortOrder;
//        mRestaurantSource.getRestaurants(this);
        initLoader();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        return mLoaderProvider.createFilteredTasksLoader(bundle.getInt(SORT_KEY));
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d(TAG, "onLoadFinished: "+data.getCount());
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onLocationChanged() {

        mRestaurantSource.getRestaurants(this);
    }

    @Override
    public void onRestaurantsFetched(List<Restaurant> restaurants) {
        initLoader();
    }

    @Override
    public void onFetchFailure() {
        Log.e(TAG, "onPresenterFetchFailure: ");
    }

    private void initLoader(){
        // we don't care about the result since the CursorLoader will load the data for us
        Bundle bundle = new Bundle();
        bundle.putInt(SORT_KEY, mSortOrder);
        if (mLoaderManager.getLoader(TASKS_LOADER) == null) {
            mLoaderManager.initLoader(TASKS_LOADER, bundle, this);
        } else {
            mLoaderManager.restartLoader(TASKS_LOADER, bundle, this);
        }
    }
}
