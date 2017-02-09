
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuggestedBounds implements Parcelable
{

    @SerializedName("ne")
    @Expose
    private Ne ne;
    @SerializedName("sw")
    @Expose
    private Sw sw;
    public final static Creator<SuggestedBounds> CREATOR = new Creator<SuggestedBounds>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SuggestedBounds createFromParcel(Parcel in) {
            SuggestedBounds instance = new SuggestedBounds();
            instance.ne = ((Ne) in.readValue((Ne.class.getClassLoader())));
            instance.sw = ((Sw) in.readValue((Sw.class.getClassLoader())));
            return instance;
        }

        public SuggestedBounds[] newArray(int size) {
            return (new SuggestedBounds[size]);
        }

    }
    ;

    public Ne getNe() {
        return ne;
    }

    public void setNe(Ne ne) {
        this.ne = ne;
    }

    public Sw getSw() {
        return sw;
    }

    public void setSw(Sw sw) {
        this.sw = sw;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ne);
        dest.writeValue(sw);
    }

    public int describeContents() {
        return  0;
    }

}
