package com.example.flowermobile.rooms;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.flowermobile.models.Account;
import com.example.flowermobile.utils.DataConvert;

@Entity(tableName = "Account")
public class AccountItemEntities {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private String accountId;
    @TypeConverters(DataConvert.class)
    @ColumnInfo(name = "account")
    private Account account;
    @NonNull
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(@NonNull String accountId) {
        this.accountId = accountId;
    }

    public AccountItemEntities() {
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
