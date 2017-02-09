
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User__ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("photo")
    @Expose
    private Photo___ photo;
    public final static Creator<User__> CREATOR = new Creator<User__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User__ createFromParcel(Parcel in) {
            User__ instance = new User__();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.firstName = ((String) in.readValue((String.class.getClassLoader())));
            instance.lastName = ((String) in.readValue((String.class.getClassLoader())));
            instance.gender = ((String) in.readValue((String.class.getClassLoader())));
            instance.photo = ((Photo___) in.readValue((Photo___.class.getClassLoader())));
            return instance;
        }

        public User__[] newArray(int size) {
            return (new User__[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Photo___ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo___ photo) {
        this.photo = photo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(gender);
        dest.writeValue(photo);
    }

    public int describeContents() {
        return  0;
    }

}
