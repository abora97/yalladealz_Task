package com.example.yalladealz.View.MainScreen;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.yalladealz.ApiCall.ApiCallBack;
import com.example.yalladealz.Model.LoginModel;
import com.example.yalladealz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.user_id)
    EditText userId;
    @BindView(R.id.user_password)
    EditText userPassword;
    @BindView(R.id.login_bt)
    Button loginBt;
    @BindView(R.id.t_id)
    TextInputLayout tId;
    @BindView(R.id.t_Password)
    TextInputLayout tPassword;

    private LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginViewModel = new LoginViewModel();
        loginBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                loginMethod();
                break;
        }
    }

    private void loginMethod() {
        String email = userId.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        if (email.isEmpty()) {
            YoYo.with(Techniques.Shake)
                    .duration(300)
                    .repeat(3)
                    .playOn(findViewById(R.id.user_id));
            tId.setError(getString(R.string.required));
            userId.requestFocus();
        } else if (password.isEmpty()) {
            YoYo.with(Techniques.Shake)
                    .duration(300)
                    .repeat(3)
                    .playOn(findViewById(R.id.user_password));
            tPassword.setError(getString(R.string.required));
            userPassword.requestFocus();
        } else {
            getUser(email, password);
        }

    }

    private void getUser(String email, String password) {

        loginViewModel.getDataMessage(email, password, new ApiCallBack() {
            @Override
            public void onSuccess(LoginModel loginModel) {
                Toast.makeText(LoginActivity.this, "User E-mail" + loginModel.getData().getEmail(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(LoginActivity.this, " " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
