package com.example.masariproject.Model;


import java.io.Serializable;
import java.util.ArrayList;

public class tours implements Serializable {
    private String name;
    private String image;
    private String description;
    private String features;
    public static ArrayList<Users> whoBooking = new ArrayList<>() ;

    public tours(String name, String image, String description, String features) {
        this.name = name;
        this.image = image;
        this.description=description;
        this.features=features;
    }

    public tours(String name, String image){
        this.name = name;
        this.image = image;
    }



    public ArrayList<Users> getWhoBooking() {
        return whoBooking;
    }

    public void setWhoBooking(ArrayList<Users> whoBooking) {
        this.whoBooking = whoBooking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}


