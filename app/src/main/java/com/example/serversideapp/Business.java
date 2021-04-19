package com.example.serversideapp;

import java.util.ArrayList;
import java.util.List;

public class Business {

    private String business_name;
    private int max_capicity;
    private String description;
    private Double latitude;
    private Double longtitude;
    private int occupancy;
    //private ArrayList<Integer> myNumbers;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    private List<String>tags;









    public Business() {

    }

    public Business(String business_name, int max_capicity, String description, Double latitude, Double longtitude, int occupancy,List<String>tags) {
        this.business_name = business_name;
        this.max_capicity = max_capicity;
        this.description = description;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.occupancy = occupancy;
        //this.myNumbers = myNumbers;
        this.tags = tags;
    }


    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public int getMax_capicity() {
        return max_capicity;
    }

    public void setMax_capicity(int max_capicity) {
        this.max_capicity = max_capicity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public int getOccupency() {
        return occupancy;
    }

    public void setOccupency(int occupency) {
        this.occupancy = occupency;
    }

    //public ArrayList<Integer> getMyNumbers() {
       // return myNumbers;



}
