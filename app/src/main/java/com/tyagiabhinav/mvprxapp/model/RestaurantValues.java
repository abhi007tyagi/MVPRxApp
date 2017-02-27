package com.tyagiabhinav.mvprxapp.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.SparseArray;

import com.tyagiabhinav.mvprxapp.model.db.DatabaseContract;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinavtyagi on 15/02/17.
 */

public class RestaurantValues {

    public static SparseArray<ContentValues[]> from(List<Restaurant> restaurants) {
        int numberOfRestaurants = restaurants.size();
        SparseArray<ContentValues[]> restaurantsMap = new SparseArray<>(numberOfRestaurants);
        ContentValues[] restaurantList = new ContentValues[numberOfRestaurants];
        ContentValues[] visitedRestaurantList = new ContentValues[numberOfRestaurants];

        for (int i = 0; i < numberOfRestaurants; i++) {

            // set default values for visited table
            ContentValues restaurantVisitedValue = new ContentValues();
            restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID, restaurants.get(i).getId());
            restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 1);
            restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 0);
            restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS, "");

            restaurantList[i] = from(restaurants.get(i));
            visitedRestaurantList[i] = restaurantVisitedValue;
        }

        restaurantsMap.put(0, restaurantList);
        restaurantsMap.put(1, visitedRestaurantList);

        return restaurantsMap;
    }

    public static ContentValues from(Restaurant restaurant) {
        ContentValues restaurantValue = new ContentValues();
//        ContentValues restaurantVisitedValue = new ContentValues();
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_RESTAURANT_ID, restaurant.getId());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_NAME, restaurant.getName());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_ADDRESS, restaurant.getAddress());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_LATITUDE, restaurant.getLat());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_LONGITUDE, restaurant.getLon());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_DISTANCE, restaurant.getDistance() / 1000);
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_PRICE, restaurant.getPrice());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_RATING, restaurant.getRating());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_IMG_URL, restaurant.getImgUrl());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_ICON_URL, restaurant.getIconUrl());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_IS_OPEN, restaurant.isOpen() ? 1 : 0);
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_URL, restaurant.getUrl());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_PHONE, restaurant.getPhone());
        restaurantValue.put(DatabaseContract.TableRestaurants.COL_TIPS, restaurant.getTips());

//        // set default values for visited table
//        restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID, restaurant.getId());
//        restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 1);
//        restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 0);
//        restaurantVisitedValue.put(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS, "");

//        valueMap.put(0, restaurantValue);
//        valueMap.put(1, restaurantVisitedValue);

        return restaurantValue;
    }

    public static List<Restaurant> getRestaurantsFromCursor(Cursor cursor) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        if (cursor != null) {
            // move cursor to first row
            if (cursor.moveToFirst()) {
                do {
                    restaurants.add(RestaurantValues.getRestaurantFromCursor(cursor));
                    // move to next row
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return restaurants;
    }

    public static Restaurant getRestaurantFromCursor(Cursor cursor) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_RESTAURANT_ID)));
        restaurant.setName(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_NAME)));
        restaurant.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_ADDRESS)));
        restaurant.setLat(cursor.getDouble(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_LATITUDE)));
        restaurant.setLon(cursor.getDouble(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_LONGITUDE)));
        restaurant.setDistance(cursor.getFloat(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_DISTANCE)));
        restaurant.setRating(cursor.getFloat(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_RATING)));
        restaurant.setPrice(cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_PRICE)));
        restaurant.setOpen((cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_IS_OPEN)) != 0) ? true : false);
        restaurant.setImgUrl(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_IMG_URL)));
        restaurant.setIconUrl(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_ICON_URL)));
        restaurant.setCategory(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_CATEGORY)));
        restaurant.setTips(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_TIPS)));
        restaurant.setUrl(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_URL)));
        restaurant.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_PHONE)));
        restaurant.setVisited((cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED)) != 0) ? true : false);
        restaurant.setVisited((cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED)) != 0) ? true : false);
        restaurant.setComments(cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS)));

        return restaurant;

    }

}
