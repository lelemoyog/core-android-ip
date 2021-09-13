
package com.issah.myrecipes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class MyrecipesSearchResponse {

    @SerializedName("from")
    @Expose
    private Double from;
    @SerializedName("to")
    @Expose
    private Double to;
    @SerializedName("count")
    @Expose
    private Double count;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MyrecipesSearchResponse() {
    }

    /**
     * 
     * @param hits
     * @param count
     * @param from
     * @param links
     * @param to
     */
    public MyrecipesSearchResponse(Double from, Double to, Double count, Links links, List<Hit> hits) {
        super();
        this.from = from;
        this.to = to;
        this.count = count;
        this.links = links;
        this.hits = hits;
    }

    public Double getFrom() {
        return from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }

    public Double getTo() {
        return to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
