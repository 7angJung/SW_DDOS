package com.example.mgit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/user/join")
    Call<RegisterResponse> userRegister(@Body RegisterData data);

    @POST("/career")
    Call<CreditResponse> userCredit(@Body CreditData data);

}
