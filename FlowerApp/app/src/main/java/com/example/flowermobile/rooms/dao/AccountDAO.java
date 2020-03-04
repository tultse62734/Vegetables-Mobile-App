package com.example.flowermobile.rooms.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.flowermobile.rooms.AccountItemEntities;

@Dao
public interface AccountDAO {
    @Insert
    void insertAccount(AccountItemEntities... accountItemEntities);

    @Query("Select * From account")
    AccountItemEntities getAccount();

    @Query("DELETE FROM account")
    void deleleAllAccount();

    @Update
    void updateAccount(AccountItemEntities... accountItemEntities);

}
