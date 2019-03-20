package com.example.exp_quotesintheair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exp_quotesintheair.utils.MyOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper moj = new MyOpenHelper(this);


    }
}
