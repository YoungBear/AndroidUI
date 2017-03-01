package com.example.androidui.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.androidui.R;

public class ProviderActivity extends Activity {

    public static final String TAG = ProviderActivity.class.getSimpleName();

    public static final String BOOK_URI = "content://com.example.hello.provider.book/book";
    public static final String USER_URI = "content://com.example.hello.provider.book/user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }).start();
    }

    private void test() {
        Uri bookUri = Uri.parse(BOOK_URI);
        ContentValues values = new ContentValues();
        values.put("_id", 1);
        values.put("name", "Android开发艺术探索");
        getContentResolver().insert(bookUri, values);
        Cursor bookCursor = getContentResolver().query(bookUri,
                new String[] {"_id", "name"}, null,null,null);
        while (bookCursor.moveToNext()) {
            int bookId = bookCursor.getInt(0);
            String bookName = bookCursor.getString(1);
            Log.d(TAG, "query book: " + "bookId: " + bookId + ", bookName: " + bookName);
        }
        bookCursor.close();

    }
}
