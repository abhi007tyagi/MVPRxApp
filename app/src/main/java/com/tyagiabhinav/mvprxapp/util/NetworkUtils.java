/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.tyagiabhinav.mvprxapp.MVPRxAPP;

/**
 * Created by abhinavtyagi on 05/01/17.
 */

public class NetworkUtils {

    private NetworkUtils(){}

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static Context getContext() {

        return MVPRxAPP.getContext();
    }

     /**
     * Check if network is available
     *
     * @return
     */
    public static boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) return false;
        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }

//    /**
//     * Get final URL
//     *
//     * @return
//     */
//    public static String getURL() {
//        String url = "https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229";
//
//        StringBuilder urlBuilder = new StringBuilder();
//        urlBuilder.append("https://api.foursquare.com/v2/venues/explore/?")
//                .append("ll=").append(mPrefHelper.getCurrentLatitude() + ",").append(mPrefHelper.getCurrentLongitude() + "&")
//                .append("venuePhotos=1&")
//                .append("limit=50&")
//                .append("sortByDistance=1&")
//                .append("section=food&");
//
//        if (!mPrefHelper.getCuisineType().isEmpty())
//            urlBuilder.append("query=").append(mPrefHelper.getCuisineType() + "&");
//
//        urlBuilder.append("oauth_token=").append(MVPRxAPP.getOAuthToken());
//
//        return urlBuilder.toString();
//    }
//
//    /**
//     * Get final URL
//     *
//     * @return
//     */
//    public static Map<String, String> getURLOptions() {
//        String url = "ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229";
//
////        StringBuilder urlBuilder = new StringBuilder();
////        urlBuilder.append("ll=").append(PrefHelper.getCurrentLatitude() + ",").append(PrefHelper.getCurrentLongitude() + "&")
////                .append("venuePhotos=1&")
////                .append("limit=50&")
////                .append("sortByDistance=1&")
////                .append("section=food&");
////
////        if (!PrefHelper.getCuisineType().isEmpty())
////            urlBuilder.append("query=").append(PrefHelper.getCuisineType() + "&");
////
////        urlBuilder.append("oauth_token=").append(MVPRxAPP.getOAuthToken());
//
//        Map<String, String> options = new HashMap<>();
//        options.put("ll", PrefHelper.getCurrentLatitude() + "," + mPrefHelper.getCurrentLongitude());
//        options.put("venuePhotos", "1");
//        options.put("limit", "50");
//        options.put("sortByDistance", "1");
//        options.put("section", "food");
//        if (!mPrefHelper.getCuisineType().isEmpty())
//            options.put("query=",mPrefHelper.getCuisineType());
//
//        options.put("oauth_token",MVPRxAPP.getOAuthToken());
//        return options;//urlBuilder.toString();
//    }
//
//    /**
//     * Get restaurant data from server and save to db
//     *
//     * @param dataFetched
//     * @param url
//     */
//    public static void geRestaurants(final IDataFetched dataFetched, String url) {
//        Log.d(TAG, "geRestaurants for --> " + url);
////        url = "https://api.foursquare.com/v2/venues/explore/?ll=28.607770,77.371988&section=food&venuePhotos=1&limit=50&sortByDistance=1&query=chinese&oauth_token=GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d(TAG, "Response->" + response);
//                int insertedRows = 0;
//                int deletedRows = 0;
//                ContentResolver contentResolver = getContext().getContentResolver();
//                try {
//                    HashMap<String, ContentValues[]> contentValues = Parsers.getRestaurantsContentValues(response);
//                    // delete all rows
//                    deletedRows = contentResolver.delete(DatabaseContract.TableRestaurants.buildRestaurantsUri(), null, null);
//                    Log.d(TAG, "deletedRows: " + deletedRows);
//
//                    // do bulk insert
//                    insertedRows = contentResolver.bulkInsert(DatabaseContract.TableRestaurants.buildRestaurantsUri(), contentValues.get(Keys.RESTAURANT_KEY));
//                    Log.d(TAG, "rows inserted to restaurant = " + insertedRows);
//                    insertedRows = contentResolver.bulkInsert(DatabaseContract.TableRestaurantsVisited.buildRestaurantsVisitedUri(), contentValues.get(Keys.RESTAURANT_VISITED_KEY));
//                    Log.d(TAG, "rows inserted to restaurant_visited = " + insertedRows);
//                    dataFetched.onDataFetched();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                onConnectionFailed(error.toString());
//                if (error != null && error.getMessage() != null) {
//                    Log.i(TAG, error.getMessage());
//                } else {
//                    Log.i(TAG, "Unknown error from server!!");
//                }
//            }
//        });
//        Volley.newRequestQueue(getContext()).add(request);
//    }



}
