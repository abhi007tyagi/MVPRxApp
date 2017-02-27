package com.tyagiabhinav.mvprxapp.view.ui.MainScreen;

import android.database.Cursor;
import android.os.Bundle;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public interface MainContract {

    interface View{
//        void updateView(List<Restaurant> restaurants);
        void updateView(Cursor cursor);
    }

    interface Presenter{
        void getData(Bundle bundle);
        void onLocationChanged();
    }
}
