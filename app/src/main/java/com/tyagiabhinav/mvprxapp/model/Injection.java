package com.tyagiabhinav.mvprxapp.model;

import android.content.Context;
import android.support.annotation.NonNull;


/**
 * Created by abhinavtyagi on 14/02/17.
 */

public class Injection  {

    private Injection(){}

    public static RestaurantSource provideRestaurantRepo(@NonNull Context context) {
        return RestaurantSource.getInstance(provideRemoteDataSource(context), provideLocalDataSource(context));
    }

    public static RemoteDataSource provideRemoteDataSource(@NonNull Context context) {
        return RemoteDataSource.getInstance(context.getContentResolver());
    }

    public static LocalDataSource provideLocalDataSource(@NonNull Context context) {
        return LocalDataSource.getInstance(context.getContentResolver());
    }

}