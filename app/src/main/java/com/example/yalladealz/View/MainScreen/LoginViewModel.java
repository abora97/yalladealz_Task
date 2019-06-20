package com.example.yalladealz.View.MainScreen;

import android.arch.lifecycle.ViewModel;

import com.example.yalladealz.ApiCall.ApiCall;
import com.example.yalladealz.ApiCall.ApiCallBack;
import com.example.yalladealz.Model.LoginModel;

public class LoginViewModel extends ViewModel {

    private ApiCall apiCall;


    public LoginViewModel() {
        apiCall = new ApiCall();
    }

    public void getDataMessage(String email, String pass, final ApiCallBack listener) {

        apiCall.userLogin(email, pass, new ApiCallBack() {
            @Override
            public void onSuccess(LoginModel loginModel) {
                listener.onSuccess(loginModel);
            }

            @Override
            public void onError(String errorMessage) {
                listener.onError(errorMessage);
            }
        });


    }
}
