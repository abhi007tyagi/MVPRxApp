
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private Boolean allowMenuUrlEdit;
    @SerializedName("beenHere")
    @Expose
    private BeenHere beenHere;
    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("hereNow")
    @Expose
    private HereNow hereNow;
    @SerializedName("featuredPhotos")
    @Expose
    private FeaturedPhotos featuredPhotos;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("ratingColor")
    @Expose
    private String ratingColor;
    @SerializedName("ratingSignals")
    @Expose
    private Integer ratingSignals;
    @SerializedName("hours")
    @Expose
    private Hours hours;
    public final static Creator<Venue> CREATOR = new Creator<Venue>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Venue createFromParcel(Parcel in) {
            Venue instance = new Venue();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.contact = ((Contact) in.readValue((Contact.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            in.readList(instance.categories, (com.tyagiabhinav.mvprxapp.model.pojo.Category.class.getClassLoader()));
            instance.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.stats = ((Stats) in.readValue((Stats.class.getClassLoader())));
            instance.price = ((Price) in.readValue((Price.class.getClassLoader())));
            instance.allowMenuUrlEdit = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.beenHere = ((BeenHere) in.readValue((BeenHere.class.getClassLoader())));
            instance.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
            instance.hereNow = ((HereNow) in.readValue((HereNow.class.getClassLoader())));
            instance.featuredPhotos = ((FeaturedPhotos) in.readValue((FeaturedPhotos.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.rating = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.ratingColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.ratingSignals = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.hours = ((Hours) in.readValue((Hours.class.getClassLoader())));
            return instance;
        }

        public Venue[] newArray(int size) {
            return (new Venue[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public FeaturedPhotos getFeaturedPhotos() {
        return featuredPhotos;
    }

    public void setFeaturedPhotos(FeaturedPhotos featuredPhotos) {
        this.featuredPhotos = featuredPhotos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public Integer getRatingSignals() {
        return ratingSignals;
    }

    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(contact);
        dest.writeValue(location);
        dest.writeList(categories);
        dest.writeValue(verified);
        dest.writeValue(stats);
        dest.writeValue(price);
        dest.writeValue(allowMenuUrlEdit);
        dest.writeValue(beenHere);
        dest.writeValue(photos);
        dest.writeValue(hereNow);
        dest.writeValue(featuredPhotos);
        dest.writeValue(url);
        dest.writeValue(rating);
        dest.writeValue(ratingColor);
        dest.writeValue(ratingSignals);
        dest.writeValue(hours);
    }

    public int describeContents() {
        return  0;
    }

}
