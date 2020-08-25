package com.dzmitrykavalioum.covidapp.service;




import java.net.CookieHandler;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.jackson.JacksonConverterFactory;
//import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {

    private static final String BASE_URL =" https://coronavirus-19-api.herokuapp.com/";// "http://192.168.1.64:8080/mobile/";//"http://192.168.1.42:8080/mobile/";//"http://192.168.1.115:8080/mobile/";
    static CovidApi instance;
    private static Retrofit retrofit;

    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //cookies auth
        JavaNetCookieJar jncj = new JavaNetCookieJar(CookieHandler.getDefault());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();//new MyCookieJar()
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())  //  addConverterFactory(JacksonConverterFactory.create())                  //
                .build();
        instance = retrofit.create(CovidApi.class);
    }

    private NetworkService() {
    }

    public static CovidApi cases() {
        return instance;
    }

    public NetworkService getCovidApi() {
        return retrofit.create(NetworkService.class);
    }
}
