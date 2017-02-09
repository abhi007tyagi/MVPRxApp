
package com.tyagiabhinav.mvprxapp.model.pojo;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group__ implements Parcelable
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
    private List<Object> items = null;
    public final static Creator<Group__> CREATOR = new Creator<Group__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Group__ createFromParcel(Parcel in) {
            Group__ instance = new Group__();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.items, (Object.class.getClassLoader()));
            return instance;
        }

        public Group__[] newArray(int size) {
            return (new Group__[size]);
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

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
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
