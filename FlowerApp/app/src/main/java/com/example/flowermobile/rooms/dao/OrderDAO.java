package com.example.flowermobile.rooms.dao;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.flowermobile.rooms.OrderItemEntities;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    void insertOrderItem(OrderItemEntities... orderItemEntities);

    @Query("Select * From `order`")
    List<OrderItemEntities> getListOrderItem();

    @Delete
    void deleteOrderItem(OrderItemEntities... orderItemEntities);

    @Update
    void updateOrder(OrderItemEntities... orderItemEntities);

    @Query("DELETE FROM `order`")
    void deleleAllOrder();
}
