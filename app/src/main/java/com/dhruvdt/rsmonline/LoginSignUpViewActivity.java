package com.dhruvdt.rsmonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginSignUpViewActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button login;
    @BindView(R.id.button2)
    Button sigup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_view);
        ButterKnife.bind(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginSignUpViewActivity.this,SignInOptions.class);
                startActivity(intent);
            }
        });
        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginSignUpViewActivity.this,SignUpOptions.class);
                startActivity(intent);
            }
        });
    }
}