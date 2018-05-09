package com.licenta.liaf.licenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.licenta.liaf.licenta.R;

public class LoginActivity extends AppCompatActivity {

    private final String FERMIER = "FERMIER";
    private final String FIRMA = "FIRMA";
    private EditText email, password;
    private Button signInButton, registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = findViewById(R.id.email);
                password = findViewById(R.id.password);
                logIn(email.getText().toString(), password.getText().toString());

            }
        });
    }

    public void registrationClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
    public void logIn(String user, String password) {
        startActivity(new Intent(LoginActivity.this, Farmers.class));
        //TO DO MINIMUM VALIDATION ON EMAIL AND PASSWORD
//  192.168.1.7
        /*
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
                        startActivity(new Intent(LoginActivity.this, Farmers.class));
                    }else if(FIRMA.equals(responseBody.getRole())) {
                        startActivity(new Intent(LoginActivity.this, Firms.class));
                    }
                } else {
                    int errorStatusCode = response.code();
                    String errorMessage = "";
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
        });*/
    }
}
