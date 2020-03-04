package com.example.flowermobile.rooms;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.flowermobile.models.Product;
import com.example.flowermobile.utils.DataConvert;

import java.io.Serializable;

@Entity(tableName = "Order")
public class OrderItemEntities implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    @NonNull
    private String orderItemId;
    @ColumnInfo(name = "Product")
    @TypeConverters(DataConvert.class)
    private Product product;
    @ColumnInfo(name = "quality")
    private int quality;
    @ColumnInfo(name = "totalPrice")
    private double total;
    public OrderItemEntities() {
    }
    @NonNull
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(@NonNull String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
