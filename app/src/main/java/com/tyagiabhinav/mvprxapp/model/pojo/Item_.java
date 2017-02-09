
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item_ implements Parcelable
{

    @SerializedName("reasons")
    @Expose
    private Reasons reasons;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("tips")
    @Expose
    private List<Tip> tips = null;
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("flags")
    @Expose
    private Flags flags;
    public final static Creator<Item_> CREATOR = new Creator<Item_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Item_ createFromParcel(Parcel in) {
            Item_ instance = new Item_();
            instance.reasons = ((Reasons) in.readValue((Reasons.class.getClassLoader())));
            instance.venue = ((Venue) in.readValue((Venue.class.getClassLoader())));
            in.readList(instance.tips, (com.tyagiabhinav.mvprxapp.model.pojo.Tip.class.getClassLoader()));
            instance.referralId = ((String) in.readValue((String.class.getClassLoader())));
            instance.flags = ((Flags) in.readValue((Flags.class.getClassLoader())));
            return instance;
        }

        public Item_[] newArray(int size) {
            return (new Item_[size]);
        }

    }
    ;

    public Reasons getReasons() {
        return reasons;
    }

    public void setReasons(Reasons reasons) {
        this.reasons = reasons;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reasons);
        dest.writeValue(venue);
        dest.writeList(tips);
        dest.writeValue(referralId);
        dest.writeValue(flags);
    }

    public int describeContents() {
        return  0;
    }

}
