package com.tyagiabhinav.mvprxapp.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;
import com.tyagiabhinav.mvprxapp.util.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by abhinavtyagi on 08/02/17.
 */

public class RestaurantRepoImpl implements  RestaurantRepo{
    @Override
    public void saveRestaurants(@NonNull Restaurant restaurant) {

    }

    @Override
    public void getRestaurants(@NonNull GetRestaurantsCallback callback) {
        Retrofit retrofit = RetrofitHelper.getInstance(null).getRetrofit();
        Call<FoursquareAPI> getRestaurantList = retrofit.create(ApiCall.class).getRestaurants();//NetworkUtils.getURLOptions());
        getRestaurantList.enqueue(new Callback<FoursquareAPI>() {
            @Override
            public void onResponse(Call<FoursquareAPI> call, Response<FoursquareAPI> repo) {
                Log.d(TAG, "onResponse IMPL: "+ repo.body().getResponse().getGroups().get(0).getItems());
            }

            @Override
            public void onFailure(Call<FoursquareAPI> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }

        });
    }

    @Override
    public void getRestaurant(@NonNull String id, @NonNull GetRestaurantCallback callback) {

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
