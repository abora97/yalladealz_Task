package com.example.yalladealz.ApiCall;

import com.example.yalladealz.Model.LoginModel;

import java.util.List;

public interface ApiCallBack {
    void onSuccess(LoginModel loginModel);

    void onError(String errorMessage);
}
