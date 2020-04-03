package com.example.flowermobile.utils;
public class ConfigAPI {
    public  static final String BASE_URL = "http://10.0.0.6:8080/api/v1/";
    public interface Api {
        String LOGIN  = "accounts/login";
        String GETALLCATEGORY = "category/getall";
        String GETALLPRODUCT = "products";
        String GETPRODUCTBYCATEID = "products/category/{id}";
        String CREATEORDER = "orders";
    }
}
