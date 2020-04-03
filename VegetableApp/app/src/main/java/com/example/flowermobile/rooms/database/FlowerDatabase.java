package com.example.flowermobile.rooms.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.rooms.dao.AccountDAO;
import com.example.flowermobile.rooms.dao.OrderDAO;


@Database(entities = {OrderItemEntities.class, AccountItemEntities.class},exportSchema = false,version = FlowerDatabase.DATABASE_VERSION)
public abstract class FlowerDatabase extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "VOFR-database";
    private static FlowerDatabase INSTANCE;
    public abstract OrderDAO orderDAO();
    public abstract AccountDAO accountDao();

    public static FlowerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FlowerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FlowerDatabase.class, DATABASE_NAME)
                            .build();
                }
            }

        }
        return INSTANCE;
    }

}
