package com.example.user.intento3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by user on 08/04/2018.
 */

public class ManejadorDataBase extends SQLiteOpenHelper{

    private static String DB_UBICACION = "data/data/com.example.user.intento3/databases";
    private static final String DB_NOMBRE = "dbuniversiapp.zip" ;

    private static SQLiteDatabase mDataBase;

    private static ManejadorDataBase sIntance = null;

    private static final int DATABASE_VERSION = 1;

    public ManejadorDataBase() {
        super(MainActivity.activity, DB_NOMBRE, null, DATABASE_VERSION);

        try {
            createDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ManejadorDataBase instance() {
        if (sIntance == null){
            sIntance = new ManejadorDataBase();
        }
        return sIntance;
    }

    private void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        SQLiteDatabase db_Read = null;

        if (dbExist){
            //La base de datos ya existe
        }else{
            db_Read = this.getReadableDatabase();
            db_Read.close();

            try{
                copyDataBase();
            } catch (IOException e){
                throw new Error ("Error copiando base de datos");
            }
        }
    }

    public boolean checkDataBase(){
        File dbFile = new File (DB_UBICACION + DB_NOMBRE);
        return dbFile.exists();
    }

    public void copyDataBase() throws IOException{
        InputStream myInput = MainActivity.activity.getAssets().open(DB_NOMBRE);

        String outFileName = DB_UBICACION + DB_NOMBRE;

        OutputStream myOutPut = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutPut.write(buffer,0,length);
        }
        myOutPut.flush();
        myOutPut.close();
        myInput.close();
    }

    private void openDataBase() throws SecurityException{
        String myPath =DB_UBICACION + DB_NOMBRE;
        mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public Cursor select(String query) throws SQLiteException{
        return  mDataBase.rawQuery(query,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
