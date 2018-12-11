package com.example.local192.geolocalisation;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class City implements Serializable {

    private String imageUrl;
    private String name;
    private Integer population;
    private double latitude;
    private double longitude;

    public City(String imageUrl, String name, Integer population, LatLng position) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.population = population;
        this.latitude = position.latitude;
        this.longitude = position.longitude;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
