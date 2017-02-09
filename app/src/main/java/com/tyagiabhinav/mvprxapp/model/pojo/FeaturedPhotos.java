
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeaturedPhotos implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Item____> items = null;
    public final static Creator<FeaturedPhotos> CREATOR = new Creator<FeaturedPhotos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FeaturedPhotos createFromParcel(Parcel in) {
            FeaturedPhotos instance = new FeaturedPhotos();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.items, (com.tyagiabhinav.mvprxapp.model.pojo.Item____.class.getClassLoader()));
            return instance;
        }

        public FeaturedPhotos[] newArray(int size) {
            return (new FeaturedPhotos[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item____> getItems() {
        return items;
    }

    public void setItems(List<Item____> items) {
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
