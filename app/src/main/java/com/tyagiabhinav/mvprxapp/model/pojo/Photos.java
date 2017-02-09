
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups")
    @Expose
    private List<Group_> groups = null;
    public final static Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            Photos instance = new Photos();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.groups, (com.tyagiabhinav.mvprxapp.model.pojo.Group_.class.getClassLoader()));
            return instance;
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Group_> getGroups() {
        return groups;
    }

    public void setGroups(List<Group_> groups) {
        this.groups = groups;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(groups);
    }

    public int describeContents() {
        return  0;
    }

}
