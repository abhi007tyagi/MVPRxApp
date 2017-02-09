
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable
{

    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("formattedPhone")
    @Expose
    private String formattedPhone;
    public final static Creator<Contact> CREATOR = new Creator<Contact>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Contact createFromParcel(Parcel in) {
            Contact instance = new Contact();
            instance.twitter = ((String) in.readValue((String.class.getClassLoader())));
            instance.phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.formattedPhone = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Contact[] newArray(int size) {
            return (new Contact[size]);
        }

    }
    ;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(twitter);
        dest.writeValue(phone);
        dest.writeValue(formattedPhone);
    }

    public int describeContents() {
        return  0;
    }

}
