package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private Helper helper;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new Helper(this);
        database = helper.getWritableDatabase();
        editText1 =findViewById(R.id.etext1);
        editText2 =findViewById(R.id.etext2);
        editText3 =findViewById(R.id.etext3);
        Button write = findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n= editText1.getText().toString();
                int s=Integer.parseInt(editText2.getText().toString());// konverterar string värdet till int
                int d=Integer.parseInt(editText3.getText().toString());
                addLake(n,s,d);
            }
        });
        textView = findViewById(R.id.text1);
        Button read=findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Lake> temp = fetchLakes();
                String tmp = "";
                for (int i = 0; i <temp.size() ; i++) {
                    tmp += temp.get(i).info()+"\n";
                }
                textView.setText(tmp);
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
    private List<Lake> fetchLakes() {
        Cursor cursor = database.query(Tables.Lake.TABLE_NAME, null, null, null, null, null, null);
        List<Lake> lakes = new ArrayList<>();
        while (cursor.moveToNext()) {
            Lake lake = new Lake(
                    cursor.getLong(cursor.getColumnIndexOrThrow(Tables.Lake.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Tables.Lake.COLUMN_NAME_NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(Tables.Lake.COLUMN_NAME_SIZE)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(Tables.Lake.COLUMN_NAME_DEPTH))
            );
            lakes.add(lake);
        }
        cursor.close();
        return lakes;
    }
}
