package com.tyagiabhinav.mvprxapp.ui;

import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public interface MainContract {

    interface View{
        void updateView(Restaurant restaurant);
    }

    interface Presenter{
        void getData(int sortOrder);
        void onLocationChanged();
    }
}
