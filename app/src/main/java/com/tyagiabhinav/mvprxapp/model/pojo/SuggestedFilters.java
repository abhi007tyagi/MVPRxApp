
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuggestedFilters implements Parcelable
{

    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("filters")
    @Expose
    private List<Filter> filters = null;
    public final static Creator<SuggestedFilters> CREATOR = new Creator<SuggestedFilters>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SuggestedFilters createFromParcel(Parcel in) {
            SuggestedFilters instance = new SuggestedFilters();
            instance.header = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.filters, (com.tyagiabhinav.mvprxapp.model.pojo.Filter.class.getClassLoader()));
            return instance;
        }

        public SuggestedFilters[] newArray(int size) {
            return (new SuggestedFilters[size]);
        }

    }
    ;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(header);
        dest.writeList(filters);
    }

    public int describeContents() {
        return  0;
    }

}
