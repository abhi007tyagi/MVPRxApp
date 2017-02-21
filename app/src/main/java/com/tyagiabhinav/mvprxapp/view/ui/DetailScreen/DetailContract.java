package com.tyagiabhinav.mvprxapp.view.ui.DetailScreen;

import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

/**
 * Created by abhinavtyagi on 17/02/17.
 */

public interface DetailContract {

    interface View{
        void updateView(Restaurant restaurant);
    }

    interface Presenter{
        void getData();
        void onActionUp(String restaurantId);
        void onActionDown(String restaurantId);
        void onReview(String restaurantId, String review);
    }

}
