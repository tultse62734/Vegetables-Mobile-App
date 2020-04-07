package com.example.flowermobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderHistory implements Serializable {
    @SerializedName("orderId")
    private int orderId;
    @SerializedName("userId")
    private int userId;
    @SerializedName("orderDate")
    private String orderDate;
    @SerializedName("total")
    private double total;
    @SerializedName("notes")
    private String notes;

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
