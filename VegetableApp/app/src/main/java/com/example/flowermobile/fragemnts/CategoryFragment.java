package com.example.flowermobile.fragemnts;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowermobile.R;
import com.example.flowermobile.activities.ProductFromCategogyActivity;
import com.example.flowermobile.adapters.CategoryAdapter;
import com.example.flowermobile.models.Category;
import com.example.flowermobile.presenters.CategoryPresenter;
import com.example.flowermobile.utils.BundleString;
import com.example.flowermobile.views.CategoryView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryView {
    private  View mView;
    private RecyclerView mRecyclerView;
    private List<Category> mCategories;
    private CategoryAdapter mCategoryAdapter;
    private CategoryPresenter mCategoryPresenter;
    public CategoryFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_category, container, false);
        initialView();
        initialData();
        return  mView;
    }
    private void initialView(){
        mRecyclerView = mView.findViewById(R.id.rcv_cate);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }
    private void initialData(){
       mCategoryPresenter = new CategoryPresenter(getContext(),this);
       mCategoryPresenter.getAllCategory();
    }
    private void updateUI(){
        if(mCategoryAdapter == null){
            mCategoryAdapter = new CategoryAdapter(getContext(),mCategories);
            mRecyclerView.setAdapter(mCategoryAdapter);
            mCategoryAdapter.onClickItem(new CategoryAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(int pos) {
                    Intent intent = new Intent(getContext(), ProductFromCategogyActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(BundleString.CATEGOGY_ID,mCategories.get(pos).getCateId());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        else {
            mCategoryAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getListCategorySuccess(List<Category> mCategoryList) {
            if(mCategoryList!=null){
                 mCategories = mCategoryList;
                updateUI();
            }
    }
    @Override
    public void getListCategoryFail(String message) {

    }
}
