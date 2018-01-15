package com.tyagiabhinav.mvprxapp.model;

import android.content.ContentResolver;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.model.pojo.Category;
import com.tyagiabhinav.mvprxapp.model.pojo.FoursquareAPI;
import com.tyagiabhinav.mvprxapp.model.pojo.Item_;
import com.tyagiabhinav.mvprxapp.model.pojo.Item___;
import com.tyagiabhinav.mvprxapp.model.pojo.Location;
import com.tyagiabhinav.mvprxapp.model.pojo.Photos;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;
import com.tyagiabhinav.mvprxapp.model.pojo.Tip;
import com.tyagiabhinav.mvprxapp.model.pojo.Venue;
import com.tyagiabhinav.mvprxapp.util.ParsingHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by abhinavtyagi on 10/02/17.
 */

public class RemoteDataSource implements DataSource {

    public static final String TAG = RemoteDataSource.class.getSimpleName();
    private static RemoteDataSource INSTANCE;

    @Inject
    Retrofit retrofit;

    // Prevent direct instantiation.
    private RemoteDataSource(@NonNull ContentResolver contentResolver) {
        MVPRxAPP.getAppComponent().inject(this);
    }

    public static RemoteDataSource getInstance(@NonNull ContentResolver contentResolver) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(contentResolver);
        }
        return INSTANCE;
    }

    @Override
    public void saveRestaurants(@NonNull List<Restaurant> restaurants) {

    }

    @Override
    public void getRestaurants(@NonNull final GetRestaurantList callback) {
//        Retrofit retrofit = RetrofitHelper.getInstance(null).getRetrofit();
        Call<FoursquareAPI> getRestaurantList = retrofit.create(ApiCall.class).getRestaurants();//NetworkUtils.getURLOptions());
        getRestaurantList.enqueue(new Callback<FoursquareAPI>() {
            @Override
            public void onResponse(Call<FoursquareAPI> call, Response<FoursquareAPI> repo) {
                Log.d(TAG, "onResponse IMPL: " + repo.body().getResponse().getGroups().get(0).getItems());
                callback.onRestaurantsFetched(extractRestaurants(repo.body()));
            }

            @Override
            public void onFailure(Call<FoursquareAPI> call, Throwable t) {
                Log.e(TAG, "onFailure: RemoteDataSource" + t.getMessage());
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

    @Override
    public List<Restaurant> extractRestaurants(@NonNull FoursquareAPI foursquareAPI) {
        List<Item_> restaurantList = foursquareAPI.getResponse().getGroups().get(0).getItems();
        int size = restaurantList.size();

        List<Restaurant> restaurants = new ArrayList<>(size); //adding size will allocate exact size for list for better performance

        // As min SDK is 16, we can't use stream feature of Java 8 here
        for (int index = 0; index < size; index++) {
            Venue venue = restaurantList.get(index).getVenue();
            Location loc = venue.getLocation();
            Photos photos = venue.getPhotos();
            Tip tip = null;
            if(restaurantList.get(index).getTips() != null) {
                tip = restaurantList.get(index).getTips().get(0);
            }

            Restaurant restaurant = new Restaurant();
            if (venue != null) {

                restaurant.setId(venue.getId());
                restaurant.setName(venue.getName());
                if(venue.getRating() != null) {
                    restaurant.setRating(venue.getRating());
                }
                restaurant.setUrl(venue.getUrl());
                if(loc != null) {
                    if(loc.getFormattedAddress() != null) {
                        restaurant.setAddress(ParsingHelper.getAddress(loc.getFormattedAddress()));
                    }
                    restaurant.setLat(loc.getLat());
                    restaurant.setLon(loc.getLng());
                    restaurant.setDistance(loc.getDistance());
                }
                if(venue.getPrice() != null){
                    restaurant.setPrice(venue.getPrice().getTier());
                }
                if(photos != null){
                    StringBuilder imgUrl = new StringBuilder();
                    Item___ item = photos.getGroups().get(0).getItems().get(0);
                    imgUrl.append(item.getPrefix())
                            .append(item.getWidth())
                            .append("x")
                            .append(item.getHeight())
                            .append(item.getSuffix());
                    restaurant.setImgUrl(imgUrl.toString());
                }
                if(venue.getCategories().get(0) != null){
                    Category cat = venue.getCategories().get(0);
                    StringBuilder iconUrl = new StringBuilder();
                    iconUrl.append(cat.getIcon().getPrefix())
                            .append("bg_88")
                            .append(cat.getIcon().getSuffix());
                    restaurant.setIconUrl(iconUrl.toString());
                }
                if(venue.getHours() != null){
                    restaurant.setOpen(venue.getHours().getIsOpen());
                }
                if(venue.getContact() != null) {
                    restaurant.setPhone(venue.getContact().getFormattedPhone());
                }
            }
            if(tip != null){
                restaurant.setTips(tip.getText());
            }
            restaurant.setConsidered(true);
            restaurant.setVisited(false);
            restaurant.setComments("");

            restaurants.add(restaurant);
        }
        return restaurants;
    }


}
