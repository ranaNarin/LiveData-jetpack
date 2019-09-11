package com.service.demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = (TextView) findViewById(R.id.tvNumber);
        //MainActivityViewModel mainActivityViewModel=new MainActivityViewModel();
        final MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<String> myNumber = mainActivityViewModel.getNumber();
        myNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvNumber.setText(s);
            }
        });


        Button btnGetValue = (Button) findViewById(R.id.btnGetValue);
        btnGetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.createNumber();
            }
        });


        Log.e(TAG, "Random number set");

    }
}
