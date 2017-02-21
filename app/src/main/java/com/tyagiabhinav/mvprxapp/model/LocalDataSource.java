package com.tyagiabhinav.mvprxapp.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;

import com.tyagiabhinav.mvprxapp.model.db.DatabaseContract;
import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by abhinavtyagi on 10/02/17.
 */

public class LocalDataSource implements DataSource {

    private static LocalDataSource INSTANCE;

    private ContentResolver mContentResolver;

    // Prevent direct instantiation.
    private LocalDataSource(@NonNull ContentResolver contentResolver) {
        mContentResolver = contentResolver;
    }

    public static LocalDataSource getInstance(@NonNull ContentResolver contentResolver) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(contentResolver);
        }
        return INSTANCE;
    }


    @Override
    public List<Restaurant> extractRestaurants(FoursquareAPI foursquareAPI) {
        return null;
    }

    @Override
    public void saveRestaurants(@NonNull List<Restaurant> restaurants) {
        SparseArray<ContentValues[]> restaurantsMap = RestaurantValues.from(restaurants);

        // delete all rows
        int deletedRows = mContentResolver.delete(DatabaseContract.TableRestaurants.buildRestaurantsUri(), null, null);
        Log.d(TAG, "deletedRows: " + deletedRows);

        // do bulk insert
        int insertedRows = mContentResolver.bulkInsert(DatabaseContract.TableRestaurants.buildRestaurantsUri(), restaurantsMap.get(0));
        Log.d(TAG, "rows inserted to restaurant = " + insertedRows);
        insertedRows = mContentResolver.bulkInsert(DatabaseContract.TableRestaurantsVisited.buildRestaurantsVisitedUri(), restaurantsMap.get(1));
        Log.d(TAG, "rows inserted to restaurant_visited = " + insertedRows);

    }

    @Override
    public void getRestaurants(@NonNull GetRestaurantList callback) {
    }

    @Override
    public void getRestaurant(@NonNull String id, @NonNull GetRestaurant callback) {
    }

    @Override
    public void reviewAction(@NonNull String id, @NonNull String review) {
        Log.d(TAG, "reviewAction..");
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS, review);

        int updatedRow = mContentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(id), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[]{id});
        Log.d(TAG, "row updated " + updatedRow);
    }

    @Override
    public void upAction(@NonNull String id) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 1);
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 1);

        int updatedRow = mContentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(id), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[]{id});
        Log.d(TAG, "row updated " + updatedRow);
    }

    @Override
    public void downAction(@NonNull String id) {
        Log.d(TAG, "doDownAction..");
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 1);
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 0);

        int updatedRow = mContentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(id), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[]{id});
        Log.d(TAG, "row updated " + updatedRow);
    }
}



