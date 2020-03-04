package com.example.flowermobile.utils;

public interface CallBackData<T> {
    void onSucess(T t);
    void onFail(String message);
}
