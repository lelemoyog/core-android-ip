
package com.issah.myrecipes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("next")
    @Expose
    private Next next;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param next
     * @param self
     */
    public Links(Self self, Next next) {
        super();
        this.self = self;
        this.next = next;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

}
