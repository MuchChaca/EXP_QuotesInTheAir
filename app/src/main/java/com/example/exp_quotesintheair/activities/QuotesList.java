package com.example.exp_quotesintheair.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.exp_quotesintheair.R;
import com.example.exp_quotesintheair.models.Quote;

public class QuotesList extends AppCompatActivity {

    ArrayAdapter<String> quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent i;
        i = new Intent(this, QuotesCreateForm.class);

        FloatingActionButton fab = findViewById(R.id.btn_create);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(i);
            }
        });

//        quotesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Quote q = new Quote();
//        q = q.getQuote(0);
        try {

            Log.d("TSTST", (q.getQuote(1)).toString()); // DEBUG

        } catch (Exception ex) {
            Log.d("TSTST", ex.getMessage());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.list_quotes) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
