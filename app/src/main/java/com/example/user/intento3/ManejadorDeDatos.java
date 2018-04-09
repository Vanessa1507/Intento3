package com.example.user.intento3;

import java.util.ArrayList;

/**
 * Created by user on 08/04/2018.
 */

public class ManejadorDeDatos extends Object {

    public static ArrayList<String> id = new ArrayList<>();
    public static ArrayList<String> nombre = new ArrayList<>();
    public static ArrayList<String> areaC = new ArrayList<>();

    private  static final ManejadorDeDatos INSTANCE = new ManejadorDeDatos();

    //=============================================================
    //                        CONSTRUCTOR
    //=============================================================

    public ManejadorDeDatos(){
    }

    //=============================================================
    //                     GETTERS & SETTERS
    //=============================================================
    public static ManejadorDeDatos getInstance(){
        return INSTANCE;
    }

    public static  ArrayList<String> obtenerListaID(){
        return id;
    }

    public static ArrayList<String> obtenerListaNombre(){
        return nombre;
    }

    public static ArrayList<String> obtenerListaAreaC(){
        return areaC;
    }

    public void SetearValores (String mID, String mNombre, String mAreaC){
        id.add(mID);
        nombre.add(mNombre);
        areaC.add(mAreaC);
    }

}
