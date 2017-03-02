package com.tyagiabhinav.mvprxapp.model.db;

/**
 * Created by abhinavtyagi on 05/01/17.
 */

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * This class contains the public contract for the database and content provider.
 */
public class DatabaseContract {

    private DatabaseContract(){}

    // Unique authority string for the content provider
    public static final String CONTENT_AUTHORITY = "com.tyagiabhinav.mvprxapp";

    // Database schema information
    public static final String TABLE_RESTAURANTS = "restaurants";
    public static final String TABLE_RESTAURANTS_VISITED = "restaurants_visited";


    public static final class TableRestaurants implements BaseColumns {
//        public static final String COL_ID = "_id";
        public static final String COL_RESTAURANT_ID = "restaurant_id";
        public static final String COL_NAME = "name";
        public static final String COL_ADDRESS = "address";
        public static final String COL_LATITUDE = "lat";
        public static final String COL_LONGITUDE = "lon";
        public static final String COL_DISTANCE = "distance";
        public static final String COL_RATING = "rating";
        public static final String COL_PRICE = "price";
        public static final String COL_IS_OPEN = "is_open";
        public static final String COL_IMG_URL = "img_url";
        public static final String COL_ICON_URL = "icon_url";
        public static final String COL_CATEGORY = "category";
        public static final String COL_TIPS = "tips";
        public static final String COL_URL = "url";
        public static final String COL_PHONE = "phone";

        // Default sort for query results - Distance
        public static final String DEFAULT_SORT_RESTAURANTS = TableRestaurants.COL_DISTANCE;
        // sort for query results based on Price
        public static final String PRICE_SORT_RESTAURANTS = TableRestaurants.COL_PRICE;
        // sort for query results based on RATING
        public static final String RATING_SORT_RESTAURANTS = TableRestaurants.COL_RATING + " DESC";
        // sort for query results based on if restaurant IS_OPEN
        public static final String IS_OPEN_SORT_RESTAURANTS = TableRestaurants.COL_IS_OPEN + " DESC";

        // Base content Uri for accessing the provider
        public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
                .authority(CONTENT_AUTHORITY)
                .appendPath(TABLE_RESTAURANTS)
                .build();

        // Defining Content type - Directory type or Item type
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_RESTAURANTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_RESTAURANTS;

        public static Uri buildRestaurantsUri() {
            return CONTENT_URI;
        }

        public static Uri buildRestaurantItemUri(String restaurantId) {
            return CONTENT_URI.buildUpon().appendPath(restaurantId).build();
        }

        public static String getRestaurantIdFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }


    public static final class TableRestaurantsVisited implements BaseColumns {
//        public static final String COL_ID = "_id";
        public static final String COL_RESTAURANT_ID = "restaurant_id";
        public static final String COL_IS_VISITED = "is_visited";
        public static final String COL_IS_CONSIDERED = "is_considered";
        public static final String COL_COMMENTS = "comments";

        // Base content Uri for accessing the provider
        public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
                .authority(CONTENT_AUTHORITY)
                .appendPath(TABLE_RESTAURANTS_VISITED)
                .build();

        // Defining Content type - Directory type or Item type
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_RESTAURANTS_VISITED;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_RESTAURANTS_VISITED;

        public static Uri buildRestaurantsVisitedUri() {
            return CONTENT_URI;
        }

        public static Uri buildRestaurantVisitedItemUri(String restaurantId) {
            return CONTENT_URI.buildUpon().appendPath(restaurantId).build();
        }

        public static String getRestaurantVisitedIdFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

}
