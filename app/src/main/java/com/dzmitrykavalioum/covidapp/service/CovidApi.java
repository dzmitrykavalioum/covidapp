package com.dzmitrykavalioum.covidapp.service;

import com.dzmitrykavalioum.covidapp.model.Country;
import com.dzmitrykavalioum.covidapp.model.Total;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {


    @GET("all")
    Call<Total> getTotal();

    @GET("countries")
    Call<List<Country>> getCountriesList();
}
