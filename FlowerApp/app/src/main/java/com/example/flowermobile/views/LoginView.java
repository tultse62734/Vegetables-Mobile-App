package com.example.flowermobile.views;

import com.example.flowermobile.models.Account;
import com.example.flowermobile.models.User;

public interface LoginView {
    void loginSuccess(Account account);
    void loginFail(String messgae);
}
