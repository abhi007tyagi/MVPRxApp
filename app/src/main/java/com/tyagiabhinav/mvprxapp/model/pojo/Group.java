
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Group implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("items")
    @Expose
    private List<Item_> items = null;
    public final static Creator<Group> CREATOR = new Creator<Group>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Group createFromParcel(Parcel in) {
            Group instance = new Group();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.items, (com.tyagiabhinav.mvprxapp.model.pojo.Item_.class.getClassLoader()));
            return instance;
        }

        public Group[] newArray(int size) {
            return (new Group[size]);
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

    public List<Item_> getItems() {
        return items;
    }

    public void setItems(List<Item_> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
