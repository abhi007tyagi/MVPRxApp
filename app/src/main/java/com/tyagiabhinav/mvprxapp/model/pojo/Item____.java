
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item____ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("user")
    @Expose
    private User_ user;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    public final static Creator<Item____> CREATOR = new Creator<Item____>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Item____ createFromParcel(Parcel in) {
            Item____ instance = new Item____();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.prefix = ((String) in.readValue((String.class.getClassLoader())));
            instance.suffix = ((String) in.readValue((String.class.getClassLoader())));
            instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.user = ((User_) in.readValue((User_.class.getClassLoader())));
            instance.visibility = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Item____[] newArray(int size) {
            return (new Item____[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(prefix);
        dest.writeValue(suffix);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(user);
        dest.writeValue(visibility);
    }

    public int describeContents() {
        return  0;
    }

}
