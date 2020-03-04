package com.example.flowermobile.utils;


import com.example.flowermobile.repositories.Service;

public class ClientApi extends  BaseApi {
    public Service Services(){
        return this.getService(Service.class,ConfigAPI.BASE_URL);
    }
}
