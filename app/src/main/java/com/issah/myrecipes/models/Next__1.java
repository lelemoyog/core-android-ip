
package com.issah.myrecipes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Next__1 {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Next__1() {
    }

    /**
     * 
     * @param href
     * @param title
     */
    public Next__1(String href, String title) {
        super();
        this.href = href;
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
