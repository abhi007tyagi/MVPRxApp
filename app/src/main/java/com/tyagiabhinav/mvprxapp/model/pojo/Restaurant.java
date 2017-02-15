package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abhinavtyagi on 05/01/17.
 */

public class Restaurant implements Parcelable {
    private String restaurantId;
    private String name;
    private String address;
    private double lat;
    private double lon;
    private float distance;
    private double rating;
    private int price;
    private boolean isOpen;
    private String imgUrl;
    private String iconUrl;
    private String category;
    private String tips;
    private String url;
    private String phone;
    private boolean isVisited;
    private boolean isConsidered;
    private String comments;

    public Restaurant(){
    }


//    public Restaurant(Cursor cursor) {
//        restaurantId = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_RESTAURANT_ID));
//        name = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_NAME));
//        address = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_ADDRESS));
//        lat = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_LATITUDE));
//        lon = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_LONGITUDE));
//        distance = cursor.getFloat(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_DISTANCE));
//        rating = cursor.getFloat(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_RATING));
//        price = cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_PRICE));
//        isOpen = (cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_IS_OPEN)) != 0) ? true : false;
//        imgUrl = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_IMG_URL));
//        iconUrl = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_ICON_URL));
//        category = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_CATEGORY));
//        tips = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_TIPS));
//        url = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_URL));
//        phone = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurants.COL_PHONE));
//        isVisited = (cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED)) != 0) ? true : false;
//        isConsidered = (cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED)) != 0) ? true : false;
//        comments = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS));
//    }

    public String getId() {
        return restaurantId;
    }

    public void setId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isConsidered() {
        return isConsidered;
    }

    public void setConsidered(boolean considered) {
        isConsidered = considered;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.restaurantId);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lon);
        dest.writeFloat(this.distance);
        dest.writeDouble(this.rating);
        dest.writeInt(this.price);
        dest.writeByte(this.isOpen ? (byte) 1 : (byte) 0);
        dest.writeString(this.imgUrl);
        dest.writeString(this.iconUrl);
        dest.writeString(this.category);
        dest.writeString(this.tips);
        dest.writeString(this.url);
        dest.writeString(this.phone);
        dest.writeByte(this.isVisited ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isConsidered ? (byte) 1 : (byte) 0);
        dest.writeString(this.comments);
    }

    public Restaurant(Parcel in) {
        this.restaurantId = in.readString();
        this.name = in.readString();
        this.address = in.readString();
        this.lat = in.readDouble();
        this.lon = in.readDouble();
        this.distance = in.readFloat();
        this.rating = in.readFloat();
        this.price = in.readInt();
        this.isOpen = in.readByte() != 0;
        this.imgUrl = in.readString();
        this.iconUrl = in.readString();
        this.category = in.readString();
        this.tips = in.readString();
        this.url = in.readString();
        this.phone = in.readString();
        this.isVisited = in.readByte() != 0;
        this.isConsidered = in.readByte() != 0;
        this.comments = in.readString();
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
