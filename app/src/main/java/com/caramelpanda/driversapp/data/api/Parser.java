package com.caramelpanda.driversapp.data.api;

import android.content.Context;
import android.widget.Toast;

import com.caramelpanda.driversapp.data.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Parser {

    final String apiUrl = "http://ip-lab.herokuapp.com/";
    final String authToken = "8bddb46b564885c3153ebd96d28bdb87c4c8d710";

    Retrofit retrofit;
    RequestAPI request;

    public Parser() {
        retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request = retrofit.create(RequestAPI.class);
    }

    public Driver checkAccount(final Context context, final Account user) {
        final User[] match = {null};
        final Driver[] result = {null};

        Call<List<User>> callUsers = request.getUsers("json");
        callUsers.enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, String.valueOf(response.message()), Toast.LENGTH_LONG).show();
                    return;
                }

                List<User> users = response.body();

                for (User acc : users) {
                    if (acc.getUsername().equals(user.getUser())
                            || acc.getEmail().equals(user.getUser())) {
                        match[0] = acc;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

        if (match[0] == null)
            return null;

        Call<List<Driver>> callDrivers = request.getDrivers("json");
        callDrivers.enqueue(new Callback<List<Driver>>() {

            @Override
            public void onResponse(Call<List<Driver>> call, Response<List<Driver>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, String.valueOf(response.message()), Toast.LENGTH_LONG).show();
                    return;
                }

                final List<Driver> drivers = response.body();

                for (Driver driver : drivers) {
                    if (driver.getUser() == match[0].getId())
                        result[0] = driver;
                }
            }

            @Override
            public void onFailure(Call<List<Driver>> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return result[0];
    }

    public Institution getInstitutionById(final int id) {
        final Institution[] result = {null};

        Call<List<Institution>> callInstitutions = request.getInstitutions("json");
        callInstitutions.enqueue(new Callback<List<Institution>>() {

            @Override
            public void onResponse(Call<List<Institution>> call, Response<List<Institution>> response) {

                if (!response.isSuccessful())
                    return;

                List<Institution> institutions = response.body();

                for (Institution inst : institutions) {
                    if (inst.getId() == id)
                        result[0] = inst;
                }
            }

            @Override
            public void onFailure(Call<List<Institution>> call, Throwable t) {
            }
        });

        return result[0];
    }
}
