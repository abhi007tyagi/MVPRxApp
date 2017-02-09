
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hours implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("isOpen")
    @Expose
    private Boolean isOpen;
    @SerializedName("isLocalHoliday")
    @Expose
    private Boolean isLocalHoliday;
    public final static Creator<Hours> CREATOR = new Creator<Hours>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Hours createFromParcel(Parcel in) {
            Hours instance = new Hours();
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.isOpen = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isLocalHoliday = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Hours[] newArray(int size) {
            return (new Hours[size]);
        }

    }
    ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Boolean getIsLocalHoliday() {
        return isLocalHoliday;
    }

    public void setIsLocalHoliday(Boolean isLocalHoliday) {
        this.isLocalHoliday = isLocalHoliday;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(isOpen);
        dest.writeValue(isLocalHoliday);
    }

    public int describeContents() {
        return  0;
    }

}
