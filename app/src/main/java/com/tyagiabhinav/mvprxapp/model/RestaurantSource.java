package com.tyagiabhinav.mvprxapp.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by abhinavtyagi on 14/02/17.
 */

public class RestaurantSource implements DataSource {

    private static RestaurantSource INSTANCE = null;

    private final DataSource mRemoteDataSource;

    private final DataSource mLocalDataSource;

    // Prevent direct instantiation.
    private RestaurantSource(@NonNull DataSource remoteDataSource,  @NonNull DataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static RestaurantSource getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new RestaurantSource(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public List<Restaurant> extractRestaurants(FoursquareAPI foursquareAPI) {
        return null;
    }

    @Override
    public void saveRestaurants(@NonNull List<Restaurant> restaurants) {
        mLocalDataSource.saveRestaurants(restaurants);
    }

    @Override
    public void getRestaurants(@NonNull final GetRestaurantList callback) {

        // Load from server
        mRemoteDataSource.getRestaurants(new GetRestaurantList() {
            @Override
            public void onRestaurantsFetched(List<Restaurant> restaurants) {
                saveRestaurants(restaurants);
                // send null as we will get this data from local db after it is saved
                callback.onRestaurantsFetched(null);
            }

            @Override
            public void onFetchFailure() {
                Log.e(TAG, "onFetchFailure: Restaurant Source");
            }
        });
    }

    @Override
    public void getRestaurant(@NonNull String id, @NonNull GetRestaurant callback) {

    }

    @Override
    public void reviewAction(@NonNull String id, @NonNull String review) {

    }

    @Override
    public void upAction(@NonNull String id) {

    }

    @Override
    public void downAction(@NonNull String id) {

    }
}
