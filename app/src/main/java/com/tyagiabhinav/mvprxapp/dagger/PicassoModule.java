package com.tyagiabhinav.mvprxapp.dagger;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@Module(includes = {ContextModule.class})
public class PicassoModule {

    @Provides
    @ApplicationScope
    public Picasso picasso(Context context){
        return new Picasso.Builder(context)
                .build();
    }
}
