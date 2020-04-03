package com.example.flowermobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {
    @SerializedName("categoryId")
    private String cateId;
    @SerializedName("categoryName")
    private String name;
    @SerializedName("categoryUrl")
    private String url;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
