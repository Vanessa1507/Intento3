package com.example.user.intento3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

/**
 * Created by user on 08/04/2018.
 */

public class ManejadorDataBase extends SQLiteOpenHelper{

    private static final String DB_NOMBRE = "dbuniversiapp.db" ;

    private static SQLiteDatabase mDataBase;

    private static ManejadorDataBase sIntance = null;

    private static final int DATABASE_VERSION = 1;

    public ManejadorDataBase() {
        super(MainActivity.activity, DB_NOMBRE, null, DATABASE_VERSION);

        /*try {
            createDataBase();
        }*/
    }

    /*private void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        SQLiteDatabase db_Read = null;

        if (dbExist){
            //La base de datos ya existe
        }else{
            db_Read = this.getReadableDatabase();
            db_Read.close();

            try{
                //copyDataBase();
            }
        }
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
