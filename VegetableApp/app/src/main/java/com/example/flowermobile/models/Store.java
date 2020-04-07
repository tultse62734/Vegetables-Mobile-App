package com.example.flowermobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Store implements Serializable {
    @SerializedName("storeId")
    private String id;
    @SerializedName("userId")
    private String userId;
    @SerializedName("storeName")
    private String storeName;
    @SerializedName("storeAddress")
    private String storeAddress;
    @SerializedName("storeImage")
    private String storeImage;
    @SerializedName("storePhoneNo")
    private String storePhone;
    @SerializedName("storeStatus")
    private int storeStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public int getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }
}
