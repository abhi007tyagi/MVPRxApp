/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */


package com.tyagiabhinav.mvprxapp.view.ui.DetailScreen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.tyagiabhinav.mvprxapp.R;
import com.tyagiabhinav.mvprxapp.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abhinavtyagi on 08/01/17.
 */

public class ReviewFragment extends DialogFragment {

    public ReviewFragment() {}

    @BindView(R.id.reviewComment)
    EditText review;

//    private String mRestaurantId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_fragment, container, false);
        ButterKnife.bind(this, rootView);

//        mRestaurantId = getArguments().getString(Constants.SELECTED_RESTAURANT_ID);

        getDialog().setTitle(getString(R.string.review_title));

        return rootView;
    }

    @OnClick(R.id.cancel)
    public void cancel(){
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED, getActivity().getIntent());
        this.dismiss();
    }

    @OnClick(R.id.ok)
    public void ok(){
        String reviewComments = review.getText().toString();
        if(TextUtils.isEmpty(reviewComments)){
            Toast.makeText(getActivity(), getString(R.string.review_empty_warning), Toast.LENGTH_SHORT).show();
        }else{
//            NetworkUtils.reviewAction(mRestaurantId, reviewComments);
            getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, getActivity().getIntent().putExtra(Constants.REVIEW_COMMENT, reviewComments));
            this.dismiss();
        }

    }
}