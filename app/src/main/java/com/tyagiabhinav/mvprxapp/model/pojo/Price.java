
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price implements Parcelable
{

    @SerializedName("tier")
    @Expose
    private Integer tier;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("currency")
    @Expose
    private String currency;
    public final static Creator<Price> CREATOR = new Creator<Price>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Price createFromParcel(Parcel in) {
            Price instance = new Price();
            instance.tier = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            instance.currency = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Price[] newArray(int size) {
            return (new Price[size]);
        }

    }
    ;

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tier);
        dest.writeValue(message);
        dest.writeValue(currency);
    }

    public int describeContents() {
        return  0;
    }

}
