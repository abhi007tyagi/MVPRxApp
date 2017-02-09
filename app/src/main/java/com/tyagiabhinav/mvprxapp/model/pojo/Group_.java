
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Group_ implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Item___> items = null;
    public final static Creator<Group_> CREATOR = new Creator<Group_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Group_ createFromParcel(Parcel in) {
            Group_ instance = new Group_();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.items, (com.tyagiabhinav.mvprxapp.model.pojo.Item___.class.getClassLoader()));
            return instance;
        }

        public Group_[] newArray(int size) {
            return (new Group_[size]);
        }

    }
    ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item___> getItems() {
        return items;
    }

    public void setItems(List<Item___> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeValue(count);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
