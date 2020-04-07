package com.example.flowermobile.repositories;

import com.example.flowermobile.utils.ConfigAPI;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @POST(ConfigAPI.Api.LOGIN)
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> login(@Body RequestBody mRequestBody);
    @GET(ConfigAPI.Api.GETALLCATEGORY)
    Call<ResponseBody> getAllCategory();
    @GET(ConfigAPI.Api.GETALLPRODUCT)
    Call<ResponseBody> getAllProduct();
    @GET(ConfigAPI.Api.GETPRODUCTBYCATEID)
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> getProductByCateId(@Path("id") int id);
    @POST(ConfigAPI.Api.CREATEORDER)
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> createOrder(@Body RequestBody mRequestBody);
    @GET(ConfigAPI.Api.GETALLSTORE)
    Call<ResponseBody> getAllStore();
    @GET(ConfigAPI.Api.GETALLORDER)
    Call<ResponseBody> getAllOrder();
}
