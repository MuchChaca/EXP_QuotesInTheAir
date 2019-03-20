package com.example.exp_quotesintheair;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exp_quotesintheair.activities.QuotesList;
import com.example.exp_quotesintheair.utils.MyOpenHelper;

public class MainActivity extends AppCompatActivity {

    public static MyOpenHelper dbHelper;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        moj = new MyOpenHelper(this);

        // Instanciate the db helper
        dbHelper = new MyOpenHelper(this);

        // Gets the data repository in write mode
        db = dbHelper.getWritableDatabase();


        Intent i;
        i = new Intent(this, QuotesList.class);
        startActivity(i);
    }
}
