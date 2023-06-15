package com.example.multiactivitycats;

import java.io.Serializable;
import java.util.ArrayList;

//This is a model class
public class Cat implements Serializable {

    String breed;
    String size;
    String eyeColor;
    String image;
    String thumbnail;
    String description;
    String shortDescription;
    String furType;
    String foundIn;
    String moreInfourl;

    public Cat(String breed, String size, String eyeColor, String image, String thumbnail, String description,
               String shortDescription, String furType, String foundIn, String moreInfourl) {
        this.breed = breed;
        this.size = size;
        this.eyeColor = eyeColor;
        this.image = image;
        this.thumbnail = thumbnail;
        this.description = description;
        this.shortDescription = shortDescription;
        this.furType = furType;
        this.foundIn = foundIn;
        this.moreInfourl = moreInfourl;
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFurType() {
        return furType;
    }

    public void setFurType(String furType) {
        this.furType = furType;
    }

    public String getFoundIn() {
        return foundIn;
    }

    public void setFoundIn(String foundIn) {
        this.foundIn = foundIn;
    }

    public String getMoreInfourl() {
        return moreInfourl;
    }

    public void setMoreInfourl(String moreInfourl) {
        this.moreInfourl = moreInfourl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
