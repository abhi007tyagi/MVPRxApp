
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item__ implements Parcelable
{

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("reasonName")
    @Expose
    private String reasonName;
    public final static Creator<Item__> CREATOR = new Creator<Item__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Item__ createFromParcel(Parcel in) {
            Item__ instance = new Item__();
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.reasonName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Item__[] newArray(int size) {
            return (new Item__[size]);
        }

    }
    ;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(summary);
        dest.writeValue(type);
        dest.writeValue(reasonName);
    }

    public int describeContents() {
        return  0;
    }

}
