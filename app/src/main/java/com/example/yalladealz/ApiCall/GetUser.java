package com.example.yalladealz.ApiCall;

import com.example.yalladealz.Model.LoginModel;
import com.example.yalladealz.Util.Constant;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface GetUser {
    @POST(Constant.LOGIN_URL)
    Call<LoginModel> Login(@Part("email")String email,@Part("password")String password);
}
