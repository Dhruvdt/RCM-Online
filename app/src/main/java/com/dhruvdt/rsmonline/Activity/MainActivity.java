package com.dhruvdt.rsmonline.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.dhruvdt.rsmonline.Activity.ProductsActivity;
import com.dhruvdt.rsmonline.R;
import com.dhruvdt.rsmonline.fcm.AccountActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
@BindView(R.id.placed_order)
    LinearLayout mPlaceOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        initViews();
        /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(MainActivity.this, LoginSignUpViewActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);*/
    }

private void initViews(){
    mPlaceOrder.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(getApplicationContext(), ProductsActivity.class);
            startActivity(intent);
        }
    });
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {     case R.id.action_setting:
                //settings
                Intent settings = new Intent(this, AccountActivity.class);
                startActivity(settings);
                break;
            default:
                // select an option
        }
        return super.onOptionsItemSelected(item);
    }
}
