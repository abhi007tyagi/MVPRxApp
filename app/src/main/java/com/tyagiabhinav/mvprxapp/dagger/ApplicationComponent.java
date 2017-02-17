package com.tyagiabhinav.mvprxapp.dagger;

import com.tyagiabhinav.mvprxapp.view.adapters.RecyclerViewAdapter;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainActivity;

import dagger.Component;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@ApplicationScope
@Component(modules = {AppModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(RecyclerViewAdapter recyclerViewAdapter);
}
