package com.tyagiabhinav.mvprxapp.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.mvprxapp.util.PrefHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhinavtyagi on 16/02/17.
 */

@Module(includes = {ContextModule.class})
public class AppModule {

    @Provides
    @ApplicationScope
    public Picasso picasso(Context context){
        return new Picasso.Builder(context).build();
    }

    @Provides
    @ApplicationScope
    public SharedPreferences getAppPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @ApplicationScope
    PrefHelper getPrefHelper(SharedPreferences prefs) {
        return new PrefHelper(prefs);
    }
}
