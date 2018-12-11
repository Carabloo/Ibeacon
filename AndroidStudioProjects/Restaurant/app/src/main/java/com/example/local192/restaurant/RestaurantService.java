package com.example.local192.restaurant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantService {
    @GET("/api/restaurants")
    Call<ListRestaurant> getRestaurants(@Query("page") int page, @Query("country") String country);
}
