package com.example.flowermobile.views;

import com.example.flowermobile.models.Product;

import java.util.List;

public interface ProductView {
    void getListProductSuccess(List<Product> mProductList);
    void getListProductFail(String messgae);
}
