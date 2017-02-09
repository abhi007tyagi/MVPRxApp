
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tip implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("photo")
    @Expose
    private Photo__ photo;
    @SerializedName("photourl")
    @Expose
    private String photourl;
    @SerializedName("logView")
    @Expose
    private Boolean logView;
    @SerializedName("agreeCount")
    @Expose
    private Integer agreeCount;
    @SerializedName("disagreeCount")
    @Expose
    private Integer disagreeCount;
    @SerializedName("todo")
    @Expose
    private Todo todo;
    @SerializedName("user")
    @Expose
    private User__ user;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    public final static Creator<Tip> CREATOR = new Creator<Tip>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tip createFromParcel(Parcel in) {
            Tip instance = new Tip();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.canonicalUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.photo = ((Photo__) in.readValue((Photo__.class.getClassLoader())));
            instance.photourl = ((String) in.readValue((String.class.getClassLoader())));
            instance.logView = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.agreeCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.disagreeCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.todo = ((Todo) in.readValue((Todo.class.getClassLoader())));
            instance.user = ((User__) in.readValue((User__.class.getClassLoader())));
            instance.likes = ((Likes) in.readValue((Likes.class.getClassLoader())));
            return instance;
        }

        public Tip[] newArray(int size) {
            return (new Tip[size]);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Photo__ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo__ photo) {
        this.photo = photo;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public Boolean getLogView() {
        return logView;
    }

    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    public Integer getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public User__ getUser() {
        return user;
    }

    public void setUser(User__ user) {
        this.user = user;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(text);
        dest.writeValue(type);
        dest.writeValue(canonicalUrl);
        dest.writeValue(photo);
        dest.writeValue(photourl);
        dest.writeValue(logView);
        dest.writeValue(agreeCount);
        dest.writeValue(disagreeCount);
        dest.writeValue(todo);
        dest.writeValue(user);
        dest.writeValue(likes);
    }

    public int describeContents() {
        return  0;
    }

}
