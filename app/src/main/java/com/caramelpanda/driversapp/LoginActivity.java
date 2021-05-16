package com.caramelpanda.driversapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.caramelpanda.driversapp.data.Account;
import com.caramelpanda.driversapp.data.api.Driver;
import com.caramelpanda.driversapp.data.api.Institution;
import com.caramelpanda.driversapp.data.api.RequestAPI;
import com.caramelpanda.driversapp.data.api.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    User userAPI = null;
    Account user = null;
    Driver driver = null;
    Institution institution = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
                final AtomicBoolean correct = new AtomicBoolean(false);
                final String apiUrl = "http://ip-lab.herokuapp.com/";
                final String authKey = "Basic bW9iaWxlOnRlbXBQQHNzdzByZA==";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(apiUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                final RequestAPI request = retrofit.create(RequestAPI.class);

                System.out.println("1");

                Call<List<User>> callUsers = request.getUsers(authKey, "json");
                callUsers.enqueue(new Callback<List<User>>() {

                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), String.valueOf(response.message()), Toast.LENGTH_LONG).show();
                            return;
                        }
                        System.out.println("2");

                        List<User> users = response.body();

                        for (User acc : users) {
                            if ((acc.getUsername().equals(username)
                                    || acc.getEmail().equals(username)) && (acc.getPassword().equals(password))) {
                                System.out.println("====3");
                                userAPI = acc;

                                Call<List<Driver>> callDrivers = request.getDrivers("json");
                                callDrivers.enqueue(new Callback<List<Driver>>() {

                                    @Override
                                    public void onResponse(Call<List<Driver>> call, Response<List<Driver>> response) {
                                        if (!response.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), String.valueOf(response.message()), Toast.LENGTH_LONG).show();
                                            return;
                                        }

                                        List<Driver> drivers = response.body();
                                        System.out.println("4");

                                        for (Driver dr : drivers) {
                                            if (dr.getUser() == userAPI.getId()) {
                                                driver = dr;
                                                System.out.println("==5");
                                                correct.set(true);

                                                Call<List<Institution>> callInstitutions = request.getInstitutions("json");
                                                callInstitutions.enqueue(new Callback<List<Institution>>() {

                                                    @Override
                                                    public void onResponse(Call<List<Institution>> call, Response<List<Institution>> response) {

                                                        if (!response.isSuccessful())
                                                            return;

                                                        List<Institution> institutions = response.body();

                                                        for (Institution inst : institutions) {
                                                            if (inst.getId() == driver.getInstitutie()) {
                                                                institution = inst;

                                                                Account account = new Account(userAPI, driver, institution);
                                                                Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_LONG).show();
                                                                Intent mainPage = new Intent(LoginActivity.this, MainActivity.class);
                                                                mainPage.putExtra("user", account);
                                                                startActivity(mainPage);
                                                                finish();
                                                            }
                                                        }
                                                    }

                                                    @Override
                                                    public void onFailure(Call<List<Institution>> call, Throwable t) {
                                                    }
                                                });
                                            }
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<Driver>> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                //Toast.makeText(getApplicationContext(), userRes.getUsername(), Toast.LENGTH_LONG).show();
                //Driver driverRes = parser.getDriver(getApplicationContext(), userRes);

//                if (driverRes != null) {
//                    Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_LONG).show();
//
//                    Institution institution = parser.getInstitutionById(driverRes.getInstitutie());
//                    user.setInstitutionName(institution.getName());
//
//                    Intent mainPage = new Intent(LoginActivity.this, MainActivity.class);
////                    Bundle b = new Bundle();
////                    b.putParcelable("user", (Parcelable) user);
////                    mainPage.putExtras(b);
//                    startActivity(mainPage);
//                    finish();
//                } else {
//                    user = null;
//                }
            }
        });
    }
}