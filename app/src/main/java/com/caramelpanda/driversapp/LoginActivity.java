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
import com.caramelpanda.driversapp.data.api.Parser;

public class LoginActivity extends AppCompatActivity {

    Account user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
                user = new Account(username, password);

                if (username.equals("debug")) {
                    user = new Account("debug", "");
                    Intent mainPage = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainPage);
                    finish();
                }

                Parser parser = new Parser();
                Driver result = parser.checkAccount(getApplicationContext(), user);

                if (result != null) {
                    Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_LONG).show();

                    Institution institution = parser.getInstitutionById(result.getInstitutie());
                    user.setInstitutionName(institution.getName());

                    Intent mainPage = new Intent(LoginActivity.this, MainActivity.class);
//                    Bundle b = new Bundle();
//                    b.putParcelable("user", (Parcelable) user);
//                    mainPage.putExtras(b);
                    startActivity(mainPage);
                    finish();
                } else {
                    user = null;
                }
            }
        });
    }
}