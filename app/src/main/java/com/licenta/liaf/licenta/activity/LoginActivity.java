package com.licenta.liaf.licenta.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.licenta.liaf.licenta.R;
import com.licenta.liaf.licenta.interfaces.UserService;
import com.licenta.liaf.licenta.model.UserRequest;
import com.licenta.liaf.licenta.model.UserResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private final String FERMIER = "FERMIER";
    private final String FIRMA = "FIRMA";
    private EditText email, password;
    private Button signInButton, registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = (EditText) findViewById(R.id.email);
                password = (EditText) findViewById(R.id.password);
                logIn(email.getText().toString(), password.getText().toString());

            }
        });
        registrationButton = (Button) findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);

            }
        });
    }

    public void logIn(String user, String password) {
        //TO DO MINIMUM VALIDATION ON EMAIL AND PASSWORD
//  192.168.1.7
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        UserRequest userRequest = new UserRequest(user,password);
        userService.login(userRequest).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    UserResponse responseBody = response.body();
                    if(FERMIER.equals(responseBody.getRole())) {
                        Intent intent = new Intent(LoginActivity.this, DisplayFermieriActivity.class);
                        startActivity(intent);
                    }else if(FIRMA.equals(responseBody.getRole())) {
                        Intent intent = new Intent(LoginActivity.this, DisplayFirmeActivity.class);
                        startActivity(intent);
                    }
                } else {
                    int errorStatusCode = response.code();
                    String errorMessage;
                    System.out.println("Eroare "  + errorStatusCode);
                    try {
                        errorMessage = response.errorBody().string();
                    } catch (IOException e) {
                        errorMessage = "Error message cannot be obtained!";
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                System.out.println("Exit on FAILURE LOGIN !!!" + t.getMessage());
            }
        });
    }
}
