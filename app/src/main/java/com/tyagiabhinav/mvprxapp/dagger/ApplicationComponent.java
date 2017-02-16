package com.tyagiabhinav.mvprxapp.dagger;

import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@ApplicationScope
@Component(modules = {PicassoModule.class})
public interface ApplicationComponent {

    Picasso getPicasso();
}
