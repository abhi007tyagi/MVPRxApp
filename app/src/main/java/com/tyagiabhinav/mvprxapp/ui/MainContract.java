package com.tyagiabhinav.mvprxapp.ui;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public interface MainContract {

    interface View{
        void updateView(String data);
    }

    interface Presenter{
        void getText(String inputData);
    }
}
