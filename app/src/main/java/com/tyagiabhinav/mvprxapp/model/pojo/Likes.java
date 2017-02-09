
package com.tyagiabhinav.mvprxapp.model.pojo;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Likes implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = null;
    @SerializedName("summary")
    @Expose
    private String summary;
    public final static Creator<Likes> CREATOR = new Creator<Likes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Likes createFromParcel(Parcel in) {
            Likes instance = new Likes();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.groups, (Object.class.getClassLoader()));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Likes[] newArray(int size) {
            return (new Likes[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(groups);
        dest.writeValue(summary);
    }

    public int describeContents() {
        return  0;
    }

}
