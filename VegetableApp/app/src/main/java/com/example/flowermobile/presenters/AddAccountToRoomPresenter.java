package com.example.flowermobile.presenters;

import android.app.Application;
import android.content.Context;

import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.rooms.management.AccountManagement;
import com.example.flowermobile.views.AddToRoomView;


public class AddAccountToRoomPresenter {
    private Context mContext;
    private Application mApplication;
    private AccountManagement accountManagement;
    private AddToRoomView addToRoomView;
    public AddAccountToRoomPresenter(Context mContext, Application Application, AddToRoomView addToRoomView) {
        this.mContext = mContext;
        this.mApplication = Application;
        accountManagement = new AccountManagement(mApplication);
        this.addToRoomView = addToRoomView;
    }
    public void addAccountToRooṃ(AccountItemEntities accountItemEntities){
        accountManagement.addAccountItem(accountItemEntities);
        addToRoomView.addToRoomSuccess();
    }

}
