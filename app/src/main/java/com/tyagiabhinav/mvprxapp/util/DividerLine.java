/*      All rights reserved. No part of this project may be reproduced, distributed,copied,transmitted or
        transformed in any form or by any means, without the prior written permission of Abhinav Tyagi.
        For permission requests,write to the developer,addressed “Attention:Permissions Coordinator,”
        at the address below.

        Abhinav Tyagi
        tyagiabhinav@yahoo.co.in */

package com.tyagiabhinav.mvprxapp.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tyagiabhinav.mvprxapp.R;


/**
 * Created by abhinavtyagi on 07/01/17.
 *
 */

public class DividerLine extends RecyclerView.ItemDecoration {

    private Drawable mDivider;

    public DividerLine(Context context) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildCount() > 1) {
            horizontalLine(c, parent);
            verticalLine(c, parent);
        }
    }

    // set horizontal divider
    private void horizontalLine(Canvas canvas, RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    // set vertical divider
    private void verticalLine(Canvas canvas, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        for (int i = 0; i < 2; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int left = child.getRight() + params.rightMargin;
            int right = left + mDivider.getIntrinsicWidth();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }
}