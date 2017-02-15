package com.tyagiabhinav.mvprxapp.model.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.MVPRxAPP;

/**
 * Created by abhinavtyagi on 08/02/17.
 */

public class DBUtils {

    private static final String TAG = DBUtils.class.getSimpleName();

    private static Context getContext() {

        return MVPRxAPP.getContext();
    }

    /**
     * Update db on Like/Up action
     *
     * @param restaurantId
     */
    public static void doUpAction(String restaurantId) {
        Log.d(TAG, "doUpAction..");
        ContentResolver contentResolver = getContext().getContentResolver();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 1);
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 1);

        int updatedRow = contentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(restaurantId), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[] {restaurantId});
        Log.d(TAG, "row updated " + updatedRow);
    }

    /**
     * Update db on Dislike/Down action
     *
     * @param restaurantId
     */
    public static void doDownAction(String restaurantId) {
        Log.d(TAG, "doDownAction..");
        ContentResolver contentResolver = getContext().getContentResolver();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 1);
        values.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 0);

        int updatedRow = contentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(restaurantId), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[] {restaurantId});
        Log.d(TAG, "row updated " + updatedRow);

    }

    /**
     * Save review comment for restaurant
     *
     * @param restaurantId
     * @param review
     */
    public static void reviewAction(String restaurantId, String review) {
        Log.d(TAG, "reviewAction..");
        ContentResolver contentResolver = getContext().getContentResolver();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS, review);

        int updatedRow = contentResolver.update(DatabaseContract.TableRestaurantsVisited.buildRestaurantVisitedItemUri(restaurantId), values, DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + "=?", new String[] {restaurantId});
        Log.d(TAG, "row updated " + updatedRow);

    }
}
