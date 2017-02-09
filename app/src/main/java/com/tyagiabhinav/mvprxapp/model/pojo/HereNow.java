
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HereNow implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("groups")
    @Expose
    private List<Group__> groups = null;
    public final static Creator<HereNow> CREATOR = new Creator<HereNow>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HereNow createFromParcel(Parcel in) {
            HereNow instance = new HereNow();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.groups, (com.tyagiabhinav.mvprxapp.model.pojo.Group__.class.getClassLoader()));
            return instance;
        }

        public HereNow[] newArray(int size) {
            return (new HereNow[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Group__> getGroups() {
        return groups;
    }

    public void setGroups(List<Group__> groups) {
        this.groups = groups;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(summary);
        dest.writeList(groups);
    }

    public int describeContents() {
        return  0;
    }

}
