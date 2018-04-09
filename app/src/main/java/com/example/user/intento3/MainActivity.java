package com.example.user.intento3;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;
    ManejadorDataBase manejadorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        manejadorDB = manejadorDB.instance();

        Cursor cursor = manejadorDB.select("SELECT * FROM uni_db_carreras");

    }

}
