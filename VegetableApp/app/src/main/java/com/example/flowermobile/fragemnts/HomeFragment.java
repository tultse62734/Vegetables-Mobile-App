package com.example.flowermobile.fragemnts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.flowermobile.R;
import com.example.flowermobile.activities.ProductDetailActivity;
import com.example.flowermobile.activities.ShoppingCartActivity;
import com.example.flowermobile.adapters.HomeAdapter;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.presenters.ProductPresenter;
import com.example.flowermobile.utils.BundleString;
import com.example.flowermobile.utils.GridSpacingItemDecoration;
import com.example.flowermobile.views.ProductView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener, ProductView {
    private View mView;
    private List<String> listImageHeader;
    private List<Product> mProductHot;
    private List<Product> mProductAll;
    private RecyclerView mRcvHotProduct;
    private RecyclerView mRcvAllProduct;
    private HomeAdapter mHotAdapter;
    private HomeAdapter mAllAdpater;
    private CarouselView mCarouselView;
    private LinearLayout mBtnShoppingCart;
    private ProductPresenter mProductPresenter;
    public HomeFragment() {
        // Required empty public constructor
    }
    public static Fragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initialView();
        setupCarousel();
        initialData();
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    private void initialView(){
        mBtnShoppingCart = mView.findViewById(R.id.btn_shopping_cart);
        mCarouselView = mView.findViewById(R.id.carouselView);
        mRcvHotProduct = mView.findViewById(R.id.rcv_hot_product);
        mRcvAllProduct = mView.findViewById(R.id.rcv_all_product);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRcvHotProduct.setLayoutManager(layoutManager);
        int numberOfColumns = calculateNumberOfColumns(getContext());
        GridLayoutManager gridLayoutManager = new
                GridLayoutManager(getActivity(), numberOfColumns);
        mRcvAllProduct.setLayoutManager(gridLayoutManager);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp20);
        mRcvAllProduct.addItemDecoration(new GridSpacingItemDecoration
                (numberOfColumns, spacingInPixels, true));
        mProductHot = new ArrayList<>();
        mProductAll = new ArrayList<>();
    }
    private int calculateNumberOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
    private void initialData(){
        mBtnShoppingCart.setOnClickListener(this);
        mProductPresenter = new ProductPresenter(getContext(),this);
        mProductPresenter.getAllProduct();
    }
    private void updateUIHot(){
        if(mHotAdapter == null){
            mHotAdapter = new HomeAdapter(getContext(),mProductHot);
            mRcvHotProduct.setAdapter(mHotAdapter);
            mHotAdapter.onItemClickListener(new HomeAdapter.OnItemClickListener() {
                @Override
                public void OnClickItem(int pos) {
                    Intent intent = new Intent(getContext(), ProductDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleString.PRODUCT_DETAIL,mProductHot.get(pos));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        else{
            mHotAdapter.notifyDataSetChanged();
        }
    }
    private void updateUIAll(){
        if(mAllAdpater == null){
            mAllAdpater = new HomeAdapter(getContext(),mProductAll);
            mRcvAllProduct.setAdapter(mAllAdpater);
            mAllAdpater.onItemClickListener(new HomeAdapter.OnItemClickListener() {
                @Override
                public void OnClickItem(int pos) {
                    Intent intent = new Intent(getContext(), ProductDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleString.PRODUCT_DETAIL,mProductAll.get(pos));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        else{
            mAllAdpater.notifyDataSetChanged();
        }
    }
    void setupCarousel(){
        listImageHeader  = new ArrayList<>();
        listImageHeader.add("https://www.vegetables.co.nz/assets/Uploads/vegetables.jpg");
        listImageHeader.add("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/12_powerhouse_vegetables_slideshow/intro_cream_of_crop.jpg");
        listImageHeader.add("https://img1.mashed.com/img/uploads/2017/07/vegetables.jpg");
        mCarouselView.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View customView = getLayoutInflater().inflate(R.layout.custom_image_header, null);
                ImageView imageView = customView.findViewById(R.id.image_header);
                Picasso.get().load(listImageHeader.get(position)).into(imageView);
                return customView;
            }
        });
        mCarouselView.setPageCount(listImageHeader.size());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_shopping_cart:
                Intent intent = new Intent(getContext(), ShoppingCartActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void getListProductSuccess(List<Product> mProductList) {
        if(mProductList!=null){
            mProductHot = mProductList;
            mProductAll = mProductList;
            updateUIAll();
            updateUIHot();
        }
    }
    @Override
    public void getListProductFail(String messgae) {

    }
}
