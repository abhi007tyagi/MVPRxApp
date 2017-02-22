package com.tyagiabhinav.mvprxapp;

import android.app.Application;
import android.content.Context;
import android.util.Base64;

import com.tyagiabhinav.crashhandler.CrashHandler;
import com.tyagiabhinav.mvprxapp.dagger.ApplicationComponent;
import com.tyagiabhinav.mvprxapp.dagger.ContextModule;
import com.tyagiabhinav.mvprxapp.dagger.DaggerApplicationComponent;

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
    private static ApplicationComponent component;

//    @Inject
//    PrefHelper mPrefHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        this.context = getApplicationContext();

        // set crash handler
        CrashHandler.init(this)
                .showStackTraceReport(true)
                .emailTo("tyagiabhinav@yahoo.co.in");

        Timber.plant(new Timber.DebugTree());

        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

//    private void initRetrofit() {
//        RetrofitHelper.getInstance(getApplicationContext());
//    }

    /**
     * Get dagger application component
     *
     * @return
     */
    public static ApplicationComponent getAppComponent() {
        return component;
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
