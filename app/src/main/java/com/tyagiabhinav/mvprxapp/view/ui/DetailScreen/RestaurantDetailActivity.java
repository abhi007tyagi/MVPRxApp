/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.view.ui.DetailScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tyagiabhinav.mvprxapp.R;
import com.tyagiabhinav.mvprxapp.util.Constants;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainActivity;


/**
 * An activity representing a single Restaurant detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link MainActivity}.
 */
public class RestaurantDetailActivity extends AppCompatActivity {

    private static final String TAG = RestaurantDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: savedInstanceState == null");
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putParcelable(Constants.SELECTED_RESTAURANT, getIntent().getExtras().getParcelable(Constants.SELECTED_RESTAURANT));
            arguments.putBoolean(Constants.TWO_PANE, getIntent().getExtras().getBoolean(Constants.TWO_PANE));
            RestaurantDetailFragment fragment = new RestaurantDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_detail_container, fragment).commit();

        }
    }
}
