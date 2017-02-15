package com.tyagiabhinav.mvprxapp.model;

import android.support.annotation.NonNull;

import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abhinavtyagi on 10/02/17.
 */

public interface DataSource {

    interface GetRestaurantList {

        void onRestaurantsFetched(List<Restaurant> restaurants);

        void onFetchFailure();
    }

    interface GetRestaurant {

        void onRestaurantFetched(Restaurant restaurant);

        void onFetchFailure();
    }

    interface ApiCall {
        // https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229
        @GET("https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229")
        Call<FoursquareAPI> getRestaurants();//@QueryMap Map<String,String> options);

    }

    List<Restaurant> extractRestaurants (FoursquareAPI foursquareAPI);

    void saveRestaurants(@NonNull List<Restaurant> restaurants);

    void getRestaurants(@NonNull GetRestaurantList callback);

    void getRestaurant(@NonNull String id, @NonNull GetRestaurant callback);

    void reviewAction(@NonNull String id, @NonNull String review);

    void upAction(@NonNull String id);

    void downAction(@NonNull String id);
}
