package com.example.yalladealz.ApiCall;

import com.example.yalladealz.Model.LoginModel;
import com.example.yalladealz.Util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiCall {
    public void userLogin(String email, String password, final ApiCallBack apiCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).build();
        GetUser getUser = retrofit.create(GetUser.class);
        getUser.Login(email, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    apiCallBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                apiCallBack.onError(t.getMessage());
            }
        });
    }
}
