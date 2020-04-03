package com.example.flowermobile.views;

import com.example.flowermobile.rooms.AccountItemEntities;

public interface GetInforAccountView {
    void getInforFail(String message);
    void getAccountFromRoom(AccountItemEntities accountItemEntities);
}
