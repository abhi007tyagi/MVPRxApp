package com.tyagiabhinav.mvprxapp;

import android.app.Application;
import android.content.Context;
import android.util.Base64;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.mvprxapp.dagger.ApplicationComponent;
import com.tyagiabhinav.mvprxapp.dagger.ContextModule;
import com.tyagiabhinav.mvprxapp.dagger.DaggerApplicationComponent;
import com.tyagiabhinav.mvprxapp.util.PrefHelper;
import com.tyagiabhinav.mvprxapp.util.RetrofitHelper;

import timber.log.Timber;

/**
 * Created by abhinavtyagi on 06/02/17.
 */

public class MVPRxAPP extends Application {


    private static Picasso picasso;

    // get token from native c++ code
    static {
        System.loadLibrary("authToken");
    }

    private static native String getAuthToken();

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        this.context = getApplicationContext();

        // set crash handler
//        CrashHandler.init(this)
//                .showStackTraceReport(true)
//                .emailTo("tyagiabhinav@yahoo.co.in");

        // initialize pref
        PrefHelper.init(getApplicationContext());

        //resetting cuisine query
        PrefHelper.setCuisineType("");

        Timber.plant(new Timber.DebugTree());

        initRetrofit();

        ApplicationComponent component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

        picasso = component.getPicasso();

    }

    private void initRetrofit() {
        RetrofitHelper.getInstance(getApplicationContext());
    }

    /**
     * Get picasso
     *
     * @return
     */
    public static Picasso getPicasso() {
        return picasso;
    }

    /**
     * Get app context
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }

    /**
     * Get OAuth token
     *
     * @return
     */
    public static String getOAuthToken() {
        return new String(Base64.decode(getAuthToken(), Base64.DEFAULT));
    }

}
