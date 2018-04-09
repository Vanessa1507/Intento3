package com.example.user.intento3;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;
    ManejadorDataBase manejadorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        manejadorDB = manejadorDB.instance();

        Cursor cursor = manejadorDB.select("SELECT * FROM uni_db_carreras ORDER BY _id ASC");

        while (cursor.moveToNext())
            ManejadorDeDatos.getInstance().SetearValores(
                    cursor.getString(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("CARRERA_NOMBRE")),
                    cursor.getString(cursor.getColumnIndex("CARRERA_AREAC_ID"))
            );

        cursor.close();

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    public void llenarLista(View v){
        final ArrayAdapter<String> idAdapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, ManejadorDeDatos.obtenerListaID());
        ((ListView) findViewById(R.id.lv_id)).setAdapter(idAdapter);

        final ArrayAdapter<String> nombreAdapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, ManejadorDeDatos.obtenerListaID());
        ((ListView) findViewById(R.id.lv_nombre)).setAdapter(nombreAdapter);

        final ArrayAdapter<String> areaCAdapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, ManejadorDeDatos.obtenerListaID());
        ((ListView) findViewById(R.id.lv_areac)).setAdapter(areaCAdapter);
    }


}
