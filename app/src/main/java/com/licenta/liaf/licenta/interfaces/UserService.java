package com.licenta.liaf.licenta.interfaces;

import com.licenta.liaf.licenta.model.UserRequest;
import com.licenta.liaf.licenta.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Lia F on 3/22/2018.
 */

public interface UserService {

    @POST("login")
    Call<UserResponse> login(@Body UserRequest userRequest);
}
