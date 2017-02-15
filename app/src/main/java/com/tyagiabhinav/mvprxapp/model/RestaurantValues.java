package com.tyagiabhinav.mvprxapp.model;

import android.content.ContentValues;
import android.util.SparseArray;

import com.tyagiabhinav.mvprxapp.model.db.DatabaseContract;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

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

        for(int i=0; i< numberOfRestaurants; i++){

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

}
