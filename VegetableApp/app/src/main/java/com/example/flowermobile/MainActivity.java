package com.example.flowermobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flowermobile.models.Product;
import com.example.flowermobile.presenters.ProductPresenter;
import com.example.flowermobile.views.ProductView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductView {
    private ProductPresenter mProductPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProductPresenter = new ProductPresenter(MainActivity.this,this);
        mProductPresenter.getAllProduct();
    }

    @Override
    public void getListProductSuccess(List<Product> mProductList) {

    }

    @Override
    public void getListProductFail(String messgae) {

    }
}
