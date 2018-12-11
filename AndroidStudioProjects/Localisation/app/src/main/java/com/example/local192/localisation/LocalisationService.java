package com.example.local192.localisation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocalisationService {
    @GET("json/{ip}")
    Call<Localisation> getLocalisation(@Path("ip")String ip);
}
