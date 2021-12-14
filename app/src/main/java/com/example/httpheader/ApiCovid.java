package com.example.httpheader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiCovid {
    @Headers({"x-rapidapi-host: covid-19-data.p.rapidapi.com",
            "x-rapidapi-key: fd45774ed5mshaac0f181a86e795p124863jsn601ba61d7021"})
    @GET("countries")
    Call<List<Pais>> getPais();
}
