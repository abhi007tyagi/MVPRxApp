package com.tyagiabhinav.mvprxapp.view.ui;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by abhinavtyagi on 06/02/17.
 */

public class SortOrder {
    private int sortOrder;

    public static final int DEFAULT = 0;
    public static final int PRICE = 1;
    public static final int RATING = 2;
    public static final int IS_OPEN = 3;

    @IntDef({DEFAULT, PRICE, RATING, IS_OPEN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogType {
    }

    @DialogType
    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(@DialogType int type) {
        this.sortOrder = sortOrder;
    }
}
