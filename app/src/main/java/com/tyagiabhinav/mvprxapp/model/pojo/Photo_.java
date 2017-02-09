
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo_ implements Parcelable
{

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    public final static Creator<Photo_> CREATOR = new Creator<Photo_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photo_ createFromParcel(Parcel in) {
            Photo_ instance = new Photo_();
            instance.prefix = ((String) in.readValue((String.class.getClassLoader())));
            instance.suffix = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Photo_[] newArray(int size) {
            return (new Photo_[size]);
        }

    }
    ;

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(prefix);
        dest.writeValue(suffix);
    }

    public int describeContents() {
        return  0;
    }

}
