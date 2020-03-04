package com.example.flowermobile.repositories;

import android.content.Context;

import com.example.flowermobile.models.Account;
import com.example.flowermobile.models.Category;
import com.example.flowermobile.models.Order;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.models.User;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.utils.ClientApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlowerRepositoryImpl implements FloweRepositoty {
    @Override
    public void login(Context context, String userame, String password, final CallBackData<Account> callBackData) {
        ClientApi clientApi = new ClientApi();
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("usernmame",userame);
            jsonObject.put("password",password);
        }catch (JSONException je){
            je.printStackTrace();
        }
        final RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonObject.toString());
        Call<ResponseBody> serviceCall = clientApi.Services().login(requestBody);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    String result = null;
                    try {
                        result = response.body().string();
                        Type type = new TypeToken<Account>(){}.getType();
                        Account account = new Gson().fromJson(result, type);
                        if(account!=null){
                            callBackData.onSucess(account);
                        }
                        else {
                            callBackData.onFail("login fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    callBackData.onFail("Login Fail");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Failure");

            }
        });
    }

    @Override
    public void getAllCategory(Context context, final CallBackData<List<Category>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.Services().getAllCategory();
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200 && response != null ){
                    String result = null;
                    try {
                        result = response.body().string();
                        Type type = new TypeToken<List<Category>>(){}.getType();
                        List<Category> mCategoryList = new Gson().fromJson(result, type);
                        if(mCategoryList!=null){
                            callBackData.onSucess(mCategoryList);
                        }
                        else {
                            callBackData.onFail("load fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    callBackData.onFail("Load Fail");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("failure");
            }
        });
    }

    @Override
    public void getAllProduct(Context context, final CallBackData<List<Product>> mCallBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.Services().getAllProduct();
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200 && response != null ){
                    String result = null;
                    try {
                        result = response.body().string();
                        Type type = new TypeToken<List<Product>>(){}.getType();
                        List<Product> mProductList = new Gson().fromJson(result, type);
                        if(mProductList!=null){
                            mCallBackData.onSucess(mProductList);
                        }
                        else {
                            mCallBackData.onFail("load fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    mCallBackData.onFail("Load Fail");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }
    @Override
    public void getProductByCateId(Context context, int cateId, final CallBackData<List<Product>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.Services().getProductByCateId(cateId);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200 && response != null ){
                    String result = null;
                    try {
                        result = response.body().string();
                        Type type = new TypeToken<List<Product>>(){}.getType();
                        List<Product> mProductList = new Gson().fromJson(result, type);
                        if(mProductList!=null){
                            callBackData.onSucess(mProductList);
                        }
                        else {
                            callBackData.onFail("load fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    callBackData.onFail("Load Fail");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    @Override
    public void createOrder(Context context, Order order, final CallBackData<String> callBackData) {
        ClientApi clientApi = new ClientApi();
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("Userld",order.getUserId());
            jsonObject.put("OrderDate",order.getOrderDate());
            jsonObject.put("Total",order.getTotal());
            jsonObject.put("Notes",order.getNotes());
        }catch (JSONException je){
            je.printStackTrace();
        }
        final RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonObject.toString());
        Call<ResponseBody> serviceCall = clientApi.Services().createOrder(requestBody);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200 && response != null ){
                    String result = null;
                    try {
                        result = response.body().string();
                        Type type = new TypeToken<String>(){}.getType();
                        String orderId = new Gson().fromJson(result, type);
                        if(orderId.length()>0){
                            callBackData.onSucess("Success");
                        }
                        else {
                            callBackData.onFail("load fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    callBackData.onFail("Load Fail");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
