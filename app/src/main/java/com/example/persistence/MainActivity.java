package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private Helper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        databaseHelper = new Helper(this);
        database = databaseHelper.getWritableDatabase();


    }

    private long addLake(String name, int size) {
        ContentValues values = new ContentValues();
        values.put(Tables.Lake.COLUMN_NAME_NAME, name);
        values.put(Tables.Lake.COLUMN_NAME_SIZE, size);
        return database.insert(Tables.Lake.TABLE_NAME, null, values);
    }
}
