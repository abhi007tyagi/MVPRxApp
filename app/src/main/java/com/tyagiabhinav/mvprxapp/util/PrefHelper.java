/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.util;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.R;

/**
 * Created by abhinavtyagi on 08/01/17.
 */

public class PrefHelper {

    private static final String TAG = PrefHelper.class.getSimpleName();


    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;


    public PrefHelper(@NonNull SharedPreferences pref) {
        this.prefs = pref;
        editor = prefs.edit();
        editor.apply();
        Log.d(TAG, "PrefHelper initialized");
    }

    /**
     * Initializes the Preference Helper class
     *
     */
//    public synchronized static void init() {
//        editor = prefs.edit();
//        editor.apply();
//        Log.d(TAG, "PrefHelper initialized");
//    }

    /**
     * Set current latitude
     *
     */
    public void setCurrentLatitude(String categories) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.latitude), categories);
        editor.commit();
        Log.d(TAG, "set Current Latitude SUCCESS");
    }

    /**
     * Get current latitude
     *
     * @return String
     */
    public String getCurrentLatitude() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.latitude), "0.000");
    }

    /**
     * Set current longitude
     *
     */
    public void setCurrentLongitude(String categories) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.longitude), categories);
        editor.commit();
        Log.d(TAG, "set Current Longitude SUCCESS");
    }

    /**
     * Get current longitude
     *
     * @return String
     */
    public String getCurrentLongitude() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.longitude), "0.000");
    }

    /**
     * Set cuisine query
     *
     */
    public void setCuisineType(String query) {
        editor.putString(MVPRxAPP.getContext().getString(R.string.query), query);
        editor.commit();
        Log.d(TAG, "set cuisine SUCCESS");
    }

    /**
     * Get cuisine query
     *
     * @return String
     */
    public String getCuisineType() {
        return prefs.getString(MVPRxAPP.getContext().getString(R.string.query), "");
    }

    /**
     * Set last location update time
     *
     */
    public void setLastLocationUpdateTime(long lastLocationUpdateTime) {
        editor.putLong(MVPRxAPP.getContext().getString(R.string.last_update_time), lastLocationUpdateTime);
        editor.commit();
        Log.d(TAG, "set last location update time SUCCESS");
    }

    /**
     * Get last location update time
     *
     * @return Long
     */
    public long getLastLocationUpdateTime() {
        return prefs.getLong(MVPRxAPP.getContext().getString(R.string.last_update_time), 0);
    }
}