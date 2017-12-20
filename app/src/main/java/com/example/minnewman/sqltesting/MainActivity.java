package com.example.minnewman.sqltesting;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.*;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView theName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase mydatabase = openOrCreateDatabase("data.db", Context.MODE_PRIVATE, null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS tutorial(name VARCHAR, number INT); ");
        mydatabase.execSQL("INSERT INTO tutorial values ('tim', 4);");
        Cursor resultSet = mydatabase.rawQuery("Select * from tutorial", null);
        resultSet.moveToFirst();
        String name = resultSet.getString(0);
        Integer number = resultSet.getInt(1);
        theName = (TextView) findViewById(R.id.textbox);
        theName.setText(name + " " + number.toString());
    }
}
