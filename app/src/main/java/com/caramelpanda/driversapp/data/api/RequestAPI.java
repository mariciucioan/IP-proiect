package com.caramelpanda.driversapp.data.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestAPI {
    @GET("soferi/")
    Call<List<Driver>> getDrivers(@Query("format") String format);

    @GET("users/")
    Call<List<User>> getUsers(@Header("Authorization") String authKey, @Query("format") String format);

    @GET("institutii/")
    Call<List<Institution>> getInstitutions(@Query("format") String format);

    @GET("institutii/{id}/")
    Call<Institution> getInstitution(@Path("id") int id);
}
