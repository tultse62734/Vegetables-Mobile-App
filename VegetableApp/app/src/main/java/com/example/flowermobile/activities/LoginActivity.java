package com.example.flowermobile.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.flowermobile.R;
import com.example.flowermobile.models.Account;
import com.example.flowermobile.models.User;
import com.example.flowermobile.presenters.AddAccountToRoomPresenter;
import com.example.flowermobile.presenters.LoginPresenter;
import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.utils.SharePreferenceUtils;
import com.example.flowermobile.views.AddToRoomView;
import com.example.flowermobile.views.LoginView;

import java.util.UUID;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView, AddToRoomView {
    private EditText mEdtUsername,mEdtPassword;
    private LinearLayout mBtnLogin,mBtnSignUp;
    private String username,password;
    private LoginPresenter mLoginPresenter;
    private AddAccountToRoomPresenter mAddAccountToRoomPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialView();
        initialData();
    }
    private void initialView(){
        mEdtUsername  = findViewById(R.id.edit_usernamae);
        mEdtPassword = findViewById(R.id.edit_password);
        mBtnLogin  = findViewById(R.id.lnl_button_sign_in);
        mBtnSignUp = findViewById(R.id.lnl_button_sign_up);
    }
    private void initialData(){
        mBtnLogin.setOnClickListener(this);
        mBtnSignUp.setOnClickListener(this);
    }
    private void login(){
        username = mEdtUsername.getText().toString();
        password  = mEdtPassword.getText().toString();
        mLoginPresenter = new LoginPresenter(LoginActivity.this,this);
        mLoginPresenter.login(username,password);
    }
    private void signUp(){
        Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.lnl_button_sign_in:
                login();
                break;
            case R.id.lnl_button_sign_up:
                signUp();
                break;
        }
    }
    @Override
    public void loginSuccess(Account account) {
        AccountItemEntities accountItemEntities= new AccountItemEntities();
        String accountId = UUID.randomUUID().toString();
        accountItemEntities.setAccountId(accountId);
        accountItemEntities.setAccount(account);
        SharePreferenceUtils.saveIntSharedPreference(LoginActivity.this,"UserId",Integer.parseInt(account.getUserId()));
        mAddAccountToRoomPresenter = new AddAccountToRoomPresenter(LoginActivity.this,getApplication(),this);
        mAddAccountToRoomPresenter.addAccountToRooṃ(accountItemEntities);
    }
    @Override
    public void loginFail(String messgae) {
        Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
    }

    @Override
    public void addToRoomSuccess() {
        Intent intent  = new Intent(LoginActivity.this,StoreActivity.class);
        startActivity(intent);
    }
}
