
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags implements Parcelable
{

    @SerializedName("outsideRadius")
    @Expose
    private Boolean outsideRadius;
    public final static Creator<Flags> CREATOR = new Creator<Flags>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Flags createFromParcel(Parcel in) {
            Flags instance = new Flags();
            instance.outsideRadius = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Flags[] newArray(int size) {
            return (new Flags[size]);
        }

    }
    ;

    public Boolean getOutsideRadius() {
        return outsideRadius;
    }

    public void setOutsideRadius(Boolean outsideRadius) {
        this.outsideRadius = outsideRadius;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(outsideRadius);
    }

    public int describeContents() {
        return  0;
    }

}
