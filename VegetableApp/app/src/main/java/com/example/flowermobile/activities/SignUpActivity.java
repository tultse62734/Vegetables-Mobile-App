package com.example.flowermobile.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.flowermobile.R;
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
   private LinearLayout mBtnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mBtnBack = findViewById(R.id.lnl_button_back);
        mBtnBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.lnl_button_back:
                finish();
                break;
        }
    }
}
