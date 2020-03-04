package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.Product;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.rooms.database.FlowerDatabase;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.ProductView;

import java.util.List;
public class ProductPresenter  {
    private Context mContext;
    private FloweRepositoty mFloweRepositoty;
    private ProductView productView;
    public ProductPresenter(Context mContext, ProductView productView) {
        this.mContext = mContext;
        this.productView = productView;
        this.mFloweRepositoty = new FlowerRepositoryImpl();
    }
    public void getAllProduct(){
        this.mFloweRepositoty.getAllProduct(mContext, new CallBackData<List<Product>>() {
            @Override
            public void onSucess(List<Product> products) {
                productView.getListProductSuccess(products);
            }

            @Override
            public void onFail(String message) {
                productView.getListProductFail(message);
            }
        });
    }
    public void getProductById(int cateId){
        mFloweRepositoty.getProductByCateId(mContext, cateId, new CallBackData<List<Product>>() {
            @Override
            public void onSucess(List<Product> products) {
                productView.getListProductSuccess(products);
            }

            @Override
            public void onFail(String message) {
                productView.getListProductFail(message);
            }
        });
    }
}
