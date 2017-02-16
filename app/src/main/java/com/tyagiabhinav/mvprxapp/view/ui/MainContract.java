package com.tyagiabhinav.mvprxapp.view.ui;

import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

import java.util.List;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public interface MainContract {

    interface View{
        void updateView(List<Restaurant> restaurants);
    }

    interface Presenter{
        void getData(int sortOrder);
        void onLocationChanged();
    }
}
