package com.example.exp_quotesintheair.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exp_quotesintheair.MainActivity;
import com.example.exp_quotesintheair.R;
import com.example.exp_quotesintheair.models.Quote;
import com.example.exp_quotesintheair.utils.MyOpenHelper;

public class QuotesCreateForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_create_form);

        final Intent iList = new Intent(this, QuotesList.class);

        Button btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuotesCreateForm.super.onBackPressed();
            }
        });

        Button btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuote();
                Snackbar.make(view, "Quotes saved !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast.makeText(QuotesCreateForm.this, "Quote saved !", Toast.LENGTH_LONG).show();
//                startActivity(iList);
                QuotesCreateForm.super.onBackPressed();
            }
        });
    }

    private void saveQuote() {
        // fetch data
        String quote = ( (EditText) findViewById(R.id.et_quote) ).getText().toString();

        // get writable database as we want to write data

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Quote.COLUMN_CONTENT, quote);

        // insert row
        long id = MainActivity.db.insert(Quote.TABLE_NAME, null, values);

        // close db connection
//        MainActivity.db.close();

//        // return newly inserted row id
//        return id;
    }
}
