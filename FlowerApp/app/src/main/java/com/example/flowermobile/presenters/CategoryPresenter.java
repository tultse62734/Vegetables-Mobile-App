package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.Category;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.CategoryView;

import java.util.List;

public class CategoryPresenter {
    private Context context;
    private FloweRepositoty mFloweRepositoty;
    private CategoryView mCategoryView;

    public CategoryPresenter(Context context, CategoryView mCategoryView) {
        this.context = context;
        this.mCategoryView = mCategoryView;
        this.mFloweRepositoty = new FlowerRepositoryImpl();
    }
    public void getAllCategory(){
        this.mFloweRepositoty.getAllCategory(context, new CallBackData<List<Category>>() {
            @Override
            public void onSucess(List<Category> categories) {
                mCategoryView.getListCategorySuccess(categories);
            }
            @Override
            public void onFail(String message) {
                mCategoryView.getListCategoryFail(message);
            }
        });
    }
}
