package com.example.local192.restaurant;

import java.util.List;

public class ListRestaurant {
    public int total_entries;
    public int per_page;
    public int current_page;
    public List<Restaurant> restaurants;

    public int getTotal_entries() {
        return total_entries;
    }

    public void setTotal_entries(int total_entries) {
        this.total_entries = total_entries;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
