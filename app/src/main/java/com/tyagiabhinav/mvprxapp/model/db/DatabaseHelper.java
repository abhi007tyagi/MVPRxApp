package com.tyagiabhinav.mvprxapp.model.db;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhinavtyagi on 05/01/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    public static final String DB_NAME = "restaurants.db";
    public static final int DB_VERSION = 1;


    private static final String SQL_CREATE_TABLE_RESTAURANTS = "CREATE TABLE  IF NOT EXISTS " +
            DatabaseContract.TABLE_RESTAURANTS + " (" +
//            DatabaseContract.TableRestaurants._ID + " INTEGER UNIQUE AUTOINCREMENT, " +
            DatabaseContract.TableRestaurants.COL_RESTAURANT_ID + " TEXT PRIMARY KEY, " +
            DatabaseContract.TableRestaurants.COL_NAME + " TEXT NOT NULL, " +
            DatabaseContract.TableRestaurants.COL_ADDRESS + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_LATITUDE + " REAL, " +
            DatabaseContract.TableRestaurants.COL_LONGITUDE + " REAL, " +
            DatabaseContract.TableRestaurants.COL_DISTANCE + " REAL, " +
            DatabaseContract.TableRestaurants.COL_RATING + " REAL, " +
            DatabaseContract.TableRestaurants.COL_PRICE + " INTEGER, " +
            DatabaseContract.TableRestaurants.COL_IS_OPEN + " INTEGER, " +
            DatabaseContract.TableRestaurants.COL_IMG_URL + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_ICON_URL + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_CATEGORY + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_TIPS + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_PHONE + " TEXT, " +
            DatabaseContract.TableRestaurants.COL_URL + " TEXT )";

    private static final String SQL_CREATE_TABLE_RESTAURANTS_VISITED = "CREATE TABLE  IF NOT EXISTS " +
            DatabaseContract.TABLE_RESTAURANTS_VISITED + " (" +
//            DatabaseContract.TableRestaurantsVisited._ID + " INTEGER UNIQUE AUTOINCREMENT," +
            DatabaseContract.TableRestaurantsVisited.COL_RESTAURANT_ID + " TEXT PRIMARY KEY," +
            DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED + " INTEGER," +
            DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED + " INTEGER," +
            DatabaseContract.TableRestaurantsVisited.COL_COMMENTS + " TEXT )";

    private Resources mResources;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        mResources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_RESTAURANTS);
        if (db.isDatabaseIntegrityOk() && db.isOpen()) {
            db.execSQL(SQL_CREATE_TABLE_RESTAURANTS);
            db.execSQL(SQL_CREATE_TABLE_RESTAURANTS_VISITED);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop only table restaurants as its a copy of online database
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_RESTAURANTS);
        onCreate(db);
    }
}
