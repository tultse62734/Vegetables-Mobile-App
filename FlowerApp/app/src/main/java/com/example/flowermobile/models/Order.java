package com.example.flowermobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Order implements Serializable {
    @SerializedName("UserId")
    private int userId;
    @SerializedName("OrderDate")
    private String OrderDate;
    @SerializedName("Total")
    private float Total;
    @SerializedName("Notes")
    private String Notes;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
