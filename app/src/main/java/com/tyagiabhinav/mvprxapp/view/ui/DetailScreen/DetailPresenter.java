package com.tyagiabhinav.mvprxapp.view.ui.DetailScreen;

import com.tyagiabhinav.mvprxapp.model.RestaurantSource;

/**
 * Created by abhinavtyagi on 17/02/17.
 */

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.View view;
    private final RestaurantSource mRestaurantSource;


    public DetailPresenter(DetailContract.View view, RestaurantSource restaurantSource) {
        this.view = view;
        this.mRestaurantSource = restaurantSource;
    }


    @Override
    public void getData() {

    }

    @Override
    public void onActionUp(String restaurantId) {
        mRestaurantSource.upAction(restaurantId);
    }

    @Override
    public void onActionDown(String restaurantId) {
        mRestaurantSource.downAction(restaurantId);
    }

    @Override
    public void onReview(String restaurantId, String review) {
        mRestaurantSource.reviewAction(restaurantId, review);
    }
}
