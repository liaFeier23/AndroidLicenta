package com.licenta.liaf.licenta.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lia F on 3/22/2018.
 */

public class UserRequest {

    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public UserRequest() {
    }

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
