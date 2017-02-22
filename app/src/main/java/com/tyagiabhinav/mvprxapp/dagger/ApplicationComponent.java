package com.tyagiabhinav.mvprxapp.dagger;

import com.tyagiabhinav.mvprxapp.model.RemoteDataSource;
import com.tyagiabhinav.mvprxapp.view.ui.DetailScreen.RestaurantDetailFragment;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainActivity;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.RecyclerViewAdapter;

import dagger.Component;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@ApplicationScope
@Component(modules = {AppModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(RecyclerViewAdapter recyclerViewAdapter);
    void inject(RestaurantDetailFragment restaurantDetailFragment);
    void inject(RemoteDataSource remoteDataSource);
}
