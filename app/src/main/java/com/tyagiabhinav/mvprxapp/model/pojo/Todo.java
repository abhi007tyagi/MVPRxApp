
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Todo implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    public final static Creator<Todo> CREATOR = new Creator<Todo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Todo createFromParcel(Parcel in) {
            Todo instance = new Todo();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Todo[] newArray(int size) {
            return (new Todo[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
    }

    public int describeContents() {
        return  0;
    }

}
