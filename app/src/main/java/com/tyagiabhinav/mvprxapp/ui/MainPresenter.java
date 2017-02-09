package com.tyagiabhinav.mvprxapp.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.model.RestaurantRepo;
import com.tyagiabhinav.mvprxapp.model.RestaurantRepoImpl;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public class MainPresenter implements MainContract.Presenter, LoaderManager.LoaderCallbacks<Cursor>{

    public static final String TAG = MainPresenter.class.getSimpleName();

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getData(int sortOrder) {
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onLocationChanged() {

        RestaurantRepoImpl restaurantRepo = new RestaurantRepoImpl();
        restaurantRepo.getRestaurants(new RestaurantRepo.GetRestaurantsCallback() {
            @Override
            public void onSuccess(List<Restaurant> restaurants) {
                Log.d(TAG, "onSuccess: "+ restaurants.size() + " found !");
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "onFailure");
            }
        });

    }
}
