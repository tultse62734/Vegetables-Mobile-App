package com.example.flowermobile.views;

import com.example.flowermobile.models.Category;

import java.util.List;

public interface CategoryView {
    void getListCategorySuccess(List<Category> mCategoryList);
    void getListCategoryFail(String message);
}
