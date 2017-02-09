package com.tyagiabhinav.mvprxapp;

import android.app.Application;
import android.content.Context;
import android.util.Base64;

import com.tyagiabhinav.mvprxapp.util.PrefHelper;
import com.tyagiabhinav.mvprxapp.util.RetrofitHelper;

import timber.log.Timber;

/**
 * Created by abhinavtyagi on 06/02/17.
 */

public class MVPRxAPP extends Application {


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


    }

    private void initRetrofit() {
        RetrofitHelper.getInstance(getApplicationContext());
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
