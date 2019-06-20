package com.example.yalladealz.ApiCall;

import com.example.yalladealz.Model.LoginModel;
import com.example.yalladealz.Util.Constant;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetUser {
    @POST(Constant.LOGIN_URL)
    @FormUrlEncoded
    Call<LoginModel> Login(@Field("email")String email, @Field("password")String password);
}
