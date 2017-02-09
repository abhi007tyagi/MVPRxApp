package com.tyagiabhinav.mvprxapp.model;

import android.support.annotation.NonNull;

import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abhinavtyagi on 06/02/17.
 */

public interface RestaurantRepo {

    interface GetRestaurantsCallback {

        void onSuccess(List<Restaurant> restaurants);

        void onFailure();
    }

    interface GetRestaurantCallback {

        void onSuccess(Restaurant restaurant);

        void onFailure();
    }

    interface ApiCall {
        // https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229
        @GET("https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229")
        Call<FoursquareAPI> getRestaurants();//@QueryMap Map<String,String> options);
    }

    void saveRestaurants(@NonNull Restaurant restaurant);

    void getRestaurants(@NonNull GetRestaurantsCallback callback);

    void getRestaurant(@NonNull String id, @NonNull GetRestaurantCallback callback);

    void reviewAction(@NonNull String id, @NonNull String review);

    void upAction(@NonNull String id);

    void downAction(@NonNull String id);

}