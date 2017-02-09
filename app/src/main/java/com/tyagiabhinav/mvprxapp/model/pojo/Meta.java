
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable
{

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("requestId")
    @Expose
    private String requestId;
    public final static Creator<Meta> CREATOR = new Creator<Meta>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Meta createFromParcel(Parcel in) {
            Meta instance = new Meta();
            instance.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.requestId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Meta[] newArray(int size) {
            return (new Meta[size]);
        }

    }
    ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(requestId);
    }

    public int describeContents() {
        return  0;
    }

}
