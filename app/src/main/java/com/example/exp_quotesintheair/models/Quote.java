package com.example.exp_quotesintheair.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.exp_quotesintheair.MainActivity;

import java.util.ArrayList;

public class Quote {

    protected long id;
    protected String content;


    public static final String TABLE_NAME = "quote";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CONTENT = "content";

    public static ArrayList<Quote> quotes = new ArrayList<Quote>();

    public Quote() {}

    public Quote(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Quote getQuote(long id) {

        Cursor cursor = MainActivity.db.query(Quote.TABLE_NAME,
                new String[]{Quote.COLUMN_ID, Quote.COLUMN_CONTENT},
                Quote.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Quote note = new Quote(
                cursor.getInt(cursor.getColumnIndex(Quote.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Quote.COLUMN_CONTENT))
        );

        // close the db connection
        cursor.close();

        return note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
