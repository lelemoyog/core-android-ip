
package com.issah.myrecipes.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Ingredient {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("food")
    @Expose
    private String food;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("foodId")
    @Expose
    private String foodId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ingredient() {
    }

    /**
     * 
     * @param quantity
     * @param measure
     * @param foodId
     * @param weight
     * @param text
     * @param food
     */
    public Ingredient(String text, Double quantity, String measure, String food,Double weight, String foodId) {
        super();
        this.text = text;
        this.quantity = quantity;
        this.measure = measure;
        this.food = food;
        this.weight = weight;
        this.foodId = foodId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s, %s, %s %s",  this.text , this.quantity ,  this.measure, this.food);
    }

}
