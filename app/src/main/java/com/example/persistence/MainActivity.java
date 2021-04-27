package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        helper = new Helper(this);
        database = helper.getWritableDatabase();
        Button write = findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 =findViewById(R.id.etext1);
                EditText editText2 =findViewById(R.id.etext2);
                EditText editText3 =findViewById(R.id.etext3);
                String n= editText1.getText().toString();
                int s=Integer.parseInt(editText2.getText().toString());// konverterar string värdet till int
                int d=Integer.parseInt(editText3.getText().toString());
                addLake(n,s,d);
            }
        });



    }

    private long addLake(String name, int size, int depth) {
        ContentValues values = new ContentValues();
        values.put(Tables.Lake.COLUMN_NAME_NAME, name);
        values.put(Tables.Lake.COLUMN_NAME_SIZE, size);
        values.put(Tables.Lake.COLUMN_NAME_DEPTH, depth);
        return database.insert(Tables.Lake.TABLE_NAME, null, values);
    }
}
