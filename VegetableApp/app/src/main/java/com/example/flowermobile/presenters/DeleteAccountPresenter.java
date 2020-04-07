package com.example.flowermobile.presenters;

import android.app.Application;
import android.content.Context;

import com.example.flowermobile.rooms.management.AccountManagement;
import com.example.flowermobile.views.DeleteAccountView;

public class DeleteAccountPresenter {
    private Context context;
    private Application application;
    private AccountManagement accountManagement;
    private DeleteAccountView mDeleteAccountView;
    public DeleteAccountPresenter(Application application, DeleteAccountView mDeleteAccountView) {
        this.application = application;
        this.accountManagement = new AccountManagement(application);
        this.mDeleteAccountView = mDeleteAccountView;
    }
    public void deleteAllAccount(){
        accountManagement.deleteAllAccount();
        mDeleteAccountView.deleteAccountSuccess("thành công");
    }
}
