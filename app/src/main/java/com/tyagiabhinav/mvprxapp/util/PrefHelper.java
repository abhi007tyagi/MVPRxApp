/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.R;

/**
 * Created by abhinavtyagi on 08/01/17.
 */

public class PrefHelper {

    private static final String TAG = PrefHelper.class.getSimpleName();


    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;


    PrefHelper() {

    }

    /**
     * Initializes the Preference Helper class
     *
     * @param ctx
     */
    public synchronized static void init(Context ctx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(MVPRxAPP.getContext());
        editor = prefs.edit();
        editor.apply();
        Log.d(TAG, "PrefHelper initialized");
    }

    /**
     * Set current latitude
     *
     */
    public synchronized static void setCurrentLatitude(String categories) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.latitude), categories);
        editor.commit();
        Log.d(TAG, "set Current Latitude SUCCESS");
    }

    /**
     * Get current latitude
     *
     * @return String
     */
    public synchronized static String getCurrentLatitude() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.latitude), "0.000");
    }

    /**
     * Set current longitude
     *
     */
    public synchronized static void setCurrentLongitude(String categories) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.longitude), categories);
        editor.commit();
        Log.d(TAG, "set Current Longitude SUCCESS");
    }

    /**
     * Get current longitude
     *
     * @return String
     */
    public synchronized static String getCurrentLongitude() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.longitude), "0.000");
    }

    /**
     * Set cuisine query
     *
     */
    public synchronized static void setCuisineType(String query) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.query), query);
        editor.commit();
        Log.d(TAG, "set cuisine SUCCESS");
    }

    /**
     * Get cuisine query
     *
     * @return String
     */
    public synchronized static String getCuisineType() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.query), "");
    }

    /**
     * Set last location update time
     *
     */
    public synchronized static void setLastLocationUpdateTime(long lastLocationUpdateTime) {
        editor.putLong(MVPRxAPP.getContext().getString(R.string.last_update_time), lastLocationUpdateTime);
        editor.commit();
        Log.d(TAG, "set last location update time SUCCESS");
    }

    /**
     * Get last location update time
     *
     * @return Long
     */
    public synchronized static long getLastLocationUpdateTime() {
        return prefs.getLong(MVPRxAPP.getContext().getString(R.string.last_update_time), 0);
    }
}