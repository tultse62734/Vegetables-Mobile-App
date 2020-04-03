package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.Account;
import com.example.flowermobile.models.User;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.LoginView;
public class LoginPresenter {
    private Context context;
    private FloweRepositoty floweRepositoty;
    private LoginView mLoginView;
    public LoginPresenter(Context context, LoginView mLoginView) {
        this.context = context;
        this.mLoginView = mLoginView;
        this.floweRepositoty = new FlowerRepositoryImpl();
    }
    public void login(String username,String password){
        this.floweRepositoty.login(context,username, password, new CallBackData<Account>() {
            @Override
            public void onSucess(Account account) {
                mLoginView.loginSuccess(account);
            }
            @Override
            public void onFail(String message) {
                mLoginView.loginFail(message);
            }
        });
    }
}
