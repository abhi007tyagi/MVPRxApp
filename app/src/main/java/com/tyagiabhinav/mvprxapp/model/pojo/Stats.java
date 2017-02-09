
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable
{

    @SerializedName("checkinsCount")
    @Expose
    private Integer checkinsCount;
    @SerializedName("usersCount")
    @Expose
    private Integer usersCount;
    @SerializedName("tipCount")
    @Expose
    private Integer tipCount;
    public final static Creator<Stats> CREATOR = new Creator<Stats>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Stats createFromParcel(Parcel in) {
            Stats instance = new Stats();
            instance.checkinsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.usersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.tipCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Stats[] newArray(int size) {
            return (new Stats[size]);
        }

    }
    ;

    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getTipCount() {
        return tipCount;
    }

    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(checkinsCount);
        dest.writeValue(usersCount);
        dest.writeValue(tipCount);
    }

    public int describeContents() {
        return  0;
    }

}
