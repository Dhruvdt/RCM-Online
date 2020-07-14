package com.dhruvdt.rsmonline.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dhruvdt.rsmonline.R;
import com.dhruvdt.rsmonline.fcm.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMenuDashboardActivity extends AppCompatActivity {
@BindView(R.id.employee)
    Button mEmployee;
    @BindView(R.id.channelPatner)
    Button mChannelPatner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_dashboard);
        ButterKnife.bind(this);
        mEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mChannelPatner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}