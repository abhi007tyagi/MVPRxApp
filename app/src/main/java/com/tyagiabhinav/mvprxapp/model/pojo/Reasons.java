
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reasons implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Item__> items = null;
    public final static Creator<Reasons> CREATOR = new Creator<Reasons>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Reasons createFromParcel(Parcel in) {
            Reasons instance = new Reasons();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.items, (com.tyagiabhinav.mvprxapp.model.pojo.Item__.class.getClassLoader()));
            return instance;
        }

        public Reasons[] newArray(int size) {
            return (new Reasons[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item__> getItems() {
        return items;
    }

    public void setItems(List<Item__> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
