package com.tyagiabhinav.mvprxapp.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@Module
public class ContextModule {

    private final Context mContext;

    public ContextModule(Context context){
        this.mContext = context;
    }

    @Provides
    public Context context(){
        return mContext;
    }
}
