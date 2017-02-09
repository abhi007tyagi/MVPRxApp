package com.tyagiabhinav.mvprxapp.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.model.db.DatabaseContract;
import com.tyagiabhinav.mvprxapp.ui.SortOrder;

/**
 * Created by abhinavtyagi on 06/02/17.
 */

public class LoaderProvider {

    private static final String TAG = LoaderProvider.class.getSimpleName();
    @NonNull
    private final Context mContext;

    public LoaderProvider(@NonNull Context context) {
        mContext = context;
    }

    public Loader<Cursor> createFilteredTasksLoader(int order) {
        Uri restaurants = DatabaseContract.TableRestaurants.buildRestaurantsUri();
        String sortOrder = DatabaseContract.TableRestaurants.DEFAULT_SORT_RESTAURANTS;
        switch (order) {
            case SortOrder.DEFAULT:
                sortOrder = DatabaseContract.TableRestaurants.DEFAULT_SORT_RESTAURANTS;
                break;
            case SortOrder.PRICE:
                sortOrder = DatabaseContract.TableRestaurants.PRICE_SORT_RESTAURANTS;
                break;
            case SortOrder.RATING:
                sortOrder = DatabaseContract.TableRestaurants.RATING_SORT_RESTAURANTS;
                break;
            case SortOrder.IS_OPEN:
                sortOrder = DatabaseContract.TableRestaurants.IS_OPEN_SORT_RESTAURANTS;
                break;
        }
        Log.d(TAG, "onCreateLoader: Sort Order -> " + sortOrder);
        Loader<Cursor> loader = new CursorLoader(mContext,
                restaurants, // uri
                null, // all columns
                DatabaseContract.TABLE_RESTAURANTS + "." + DatabaseContract.TableRestaurants.COL_RESTAURANT_ID +
                        "=" + DatabaseContract.TABLE_RESTAURANTS_VISITED + "." + DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID +
                        " AND " + DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED + " =1 ", // WHERE
                null, // selection args
                sortOrder);
        return loader;
    }

}
