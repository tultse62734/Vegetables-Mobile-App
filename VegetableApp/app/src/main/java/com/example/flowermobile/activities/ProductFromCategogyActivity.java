package com.example.flowermobile.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.flowermobile.R;
import com.example.flowermobile.adapters.CategogyProductAdapter;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.presenters.ProductPresenter;
import com.example.flowermobile.utils.BundleString;
import com.example.flowermobile.views.ProductView;

import java.util.ArrayList;
import java.util.List;
public class ProductFromCategogyActivity extends AppCompatActivity implements ProductView {
    private RecyclerView mRecyclerView;
    private List<Product> mProductList;
    private CategogyProductAdapter mAdapter;
    private String cateid;
    private ProductPresenter mProductPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_from_categogy);
        initialView();
        initialData();
    }
    private void initialView(){
        mRecyclerView = findViewById(R.id.rcv_cate_product);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(ProductFromCategogyActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }
    private void initialData(){
        Bundle bundle = getIntent().getExtras();
        cateid = (String)bundle.getString(BundleString.CATEGOGY_ID);
        mProductPresenter = new ProductPresenter(ProductFromCategogyActivity.this,this);
        mProductPresenter.getProductById(Integer.parseInt(cateid));

    }
    private void updateUI(){
        if(mAdapter == null ){
            mAdapter = new CategogyProductAdapter(ProductFromCategogyActivity.this,mProductList);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.onItemClick(new CategogyProductAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(int pos) {
                    Intent intent = new Intent(ProductFromCategogyActivity.this, ProductDetailActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            mAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void getListProductSuccess(List<Product> mProductList) {
        if(mProductList!=null){
            this.mProductList = new ArrayList<>();
            this.mProductList = mProductList;
            updateUI();
        }
    }
    @Override
    public void getListProductFail(String messgae) {

    }
}
