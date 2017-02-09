
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("item")
    @Expose
    private Item item;
    public final static Creator<Notification> CREATOR = new Creator<Notification>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Notification createFromParcel(Parcel in) {
            Notification instance = new Notification();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.item = ((Item) in.readValue((Item.class.getClassLoader())));
            return instance;
        }

        public Notification[] newArray(int size) {
            return (new Notification[size]);
        }

    }
    ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(item);
    }

    public int describeContents() {
        return  0;
    }

}
