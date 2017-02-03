package com.tyagiabhinav.mvprxapp.ui;

/**
 * Created by abhinavtyagi on 03/02/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }
    @Override
    public void getText(String inputData) {
        view.updateView(inputData);
    }
}
