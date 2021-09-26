
package com.issah.myrecipes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Hit {

    @SerializedName("recipe")
    @Expose
    private Recipe recipe;
    @SerializedName("_links")
    @Expose
    private Links__1 links;

    /**
     * No args constructor for use in serialization
     * 
     */
    private String pushId;
    String index;
    public Hit() {
    }

    /**
     * 
     * @param recipe
     * @param links
     */
    public Hit(Recipe recipe, Links__1 links) {
        super();
        this.recipe = recipe;
        this.links = links;
        this.index = "not_specified";
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Links__1 getLinks() {
        return links;
    }

    public void setLinks(Links__1 links) {
        this.links = links;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
