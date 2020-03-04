package com.example.flowermobile.presenters;

import android.app.Application;
import android.content.Context;

import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.rooms.management.AccountManagement;
import com.example.flowermobile.views.GetInforAccountView;

public class InformationAccountPresenter {
    private Context context;
    private Application application;
    private AccountManagement accountManagement;
    private GetInforAccountView mInforAccountView;

    public InformationAccountPresenter(Application application, GetInforAccountView mInforAccountView) {
        this.application = application;
        this.accountManagement = new AccountManagement(application);
        this.mInforAccountView = mInforAccountView;
    }


    public void getAccountFromRoom(){
        accountManagement.getAccountItem(new AccountManagement.DataCallBack() {
            @Override
            public void onSuccess(AccountItemEntities account) {
                mInforAccountView.getAccountFromRoom(account);
            }
            @Override
            public void onFail(String message) {
                mInforAccountView.getInforFail(message);
            }
        });
    }
}