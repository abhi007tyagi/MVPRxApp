
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeenHere implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("marked")
    @Expose
    private Boolean marked;
    @SerializedName("lastCheckinExpiredAt")
    @Expose
    private Integer lastCheckinExpiredAt;
    public final static Creator<BeenHere> CREATOR = new Creator<BeenHere>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BeenHere createFromParcel(Parcel in) {
            BeenHere instance = new BeenHere();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.marked = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.lastCheckinExpiredAt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public BeenHere[] newArray(int size) {
            return (new BeenHere[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Integer getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(marked);
        dest.writeValue(lastCheckinExpiredAt);
    }

    public int describeContents() {
        return  0;
    }

}
