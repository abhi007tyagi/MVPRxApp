
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoursquareAPI implements Parcelable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("notifications")
    @Expose
    private List<Notification> notifications = null;
    @SerializedName("response")
    @Expose
    private Response response;
    public final static Creator<FoursquareAPI> CREATOR = new Creator<FoursquareAPI>() {


    @SuppressWarnings({"unchecked"})
    public FoursquareAPI createFromParcel(Parcel in) {
        FoursquareAPI instance = new FoursquareAPI();
        instance.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
        in.readList(instance.notifications, (com.tyagiabhinav.mvprxapp.model.pojo.Notification.class.getClassLoader()));
        instance.response = ((Response) in.readValue((Response.class.getClassLoader())));
        return instance;
    }

    public FoursquareAPI[] newArray(int size) {
            return (new FoursquareAPI[size]);
        }

    };

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
        dest.writeList(notifications);
        dest.writeValue(response);
    }

    public int describeContents() {
        return 0;
    }

}
