
package com.tyagiabhinav.mvprxapp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response implements Parcelable
{

    @SerializedName("suggestedFilters")
    @Expose
    private SuggestedFilters suggestedFilters;
    @SerializedName("suggestedRadius")
    @Expose
    private Integer suggestedRadius;
    @SerializedName("headerLocation")
    @Expose
    private String headerLocation;
    @SerializedName("headerFullLocation")
    @Expose
    private String headerFullLocation;
    @SerializedName("headerLocationGranularity")
    @Expose
    private String headerLocationGranularity;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("suggestedBounds")
    @Expose
    private SuggestedBounds suggestedBounds;
    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;
    public final static Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Response createFromParcel(Parcel in) {
            Response instance = new Response();
            instance.suggestedFilters = ((SuggestedFilters) in.readValue((SuggestedFilters.class.getClassLoader())));
            instance.suggestedRadius = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.headerLocation = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerFullLocation = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerLocationGranularity = ((String) in.readValue((String.class.getClassLoader())));
            instance.query = ((String) in.readValue((String.class.getClassLoader())));
            instance.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.suggestedBounds = ((SuggestedBounds) in.readValue((SuggestedBounds.class.getClassLoader())));
            in.readList(instance.groups, (com.tyagiabhinav.mvprxapp.model.pojo.Group.class.getClassLoader()));
            return instance;
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    }
    ;

    public SuggestedFilters getSuggestedFilters() {
        return suggestedFilters;
    }

    public void setSuggestedFilters(SuggestedFilters suggestedFilters) {
        this.suggestedFilters = suggestedFilters;
    }

    public Integer getSuggestedRadius() {
        return suggestedRadius;
    }

    public void setSuggestedRadius(Integer suggestedRadius) {
        this.suggestedRadius = suggestedRadius;
    }

    public String getHeaderLocation() {
        return headerLocation;
    }

    public void setHeaderLocation(String headerLocation) {
        this.headerLocation = headerLocation;
    }

    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    public void setHeaderFullLocation(String headerFullLocation) {
        this.headerFullLocation = headerFullLocation;
    }

    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    public void setHeaderLocationGranularity(String headerLocationGranularity) {
        this.headerLocationGranularity = headerLocationGranularity;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public SuggestedBounds getSuggestedBounds() {
        return suggestedBounds;
    }

    public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
        this.suggestedBounds = suggestedBounds;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(suggestedFilters);
        dest.writeValue(suggestedRadius);
        dest.writeValue(headerLocation);
        dest.writeValue(headerFullLocation);
        dest.writeValue(headerLocationGranularity);
        dest.writeValue(query);
        dest.writeValue(totalResults);
        dest.writeValue(suggestedBounds);
        dest.writeList(groups);
    }

    public int describeContents() {
        return  0;
    }

}
