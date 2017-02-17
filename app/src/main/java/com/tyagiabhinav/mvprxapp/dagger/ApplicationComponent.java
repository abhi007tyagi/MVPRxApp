package com.tyagiabhinav.mvprxapp.dagger;

import com.tyagiabhinav.mvprxapp.view.adapters.RecyclerViewAdapter;

import dagger.Component;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@ApplicationScope
@Component(modules = {PicassoModule.class})
public interface ApplicationComponent {

    void inject(RecyclerViewAdapter recyclerViewAdapter);
}
