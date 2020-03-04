package com.example.flowermobile.fragemnts;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flowermobile.R;
import com.example.flowermobile.activities.LoginActivity;
import com.example.flowermobile.presenters.InformationAccountPresenter;
import com.example.flowermobile.rooms.AccountItemEntities;
import com.example.flowermobile.views.GetInforAccountView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements GetInforAccountView, View.OnClickListener {
        private InformationAccountPresenter mInformationAccountPresenter;
        private View mView;
        private TextView mTxtUsername,mTxtEmail,mTxtPhone,mTxtAddress;
        private LinearLayout mBtnSignOut;
    public ProfileFragment() {
        // Required empty public constructor
    }
    public static Fragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mView =  inflater.inflate(R.layout.fragment_profile, container, false);
       initialView();
       initialData();
        return  mView;
    }
    private void initialView(){
        mBtnSignOut = mView.findViewById(R.id.lnl_button_sign_out);
        mTxtUsername = mView.findViewById(R.id.txt_name_account);
        mTxtEmail = mView.findViewById(R.id.txt_email_account);
        mTxtPhone = mView.findViewById(R.id.txt_phone_account);
        mTxtAddress = mView.findViewById(R.id.txt_address_account);
    }
    private void initialData(){
        mBtnSignOut.setOnClickListener(this);
        mInformationAccountPresenter = new InformationAccountPresenter(getActivity().getApplication(),this);
        mInformationAccountPresenter.getAccountFromRoom();
    }
    @Override
    public void getInforFail(String message) {

    }
    @Override
    public void getAccountFromRoom(AccountItemEntities accountItemEntities) {
        mTxtUsername.setText(accountItemEntities.getAccount().getUserName()+"");
        mTxtAddress.setText(accountItemEntities.getAccount().getUserAddress()+"");
        mTxtPhone.setText(accountItemEntities.getAccount().getPhone()+"");
        mTxtEmail.setText(accountItemEntities.getAccount().getEmail()+"");
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
            switch (id){
                case R.id.lnl_button_sign_out:
                    Intent intent  = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

