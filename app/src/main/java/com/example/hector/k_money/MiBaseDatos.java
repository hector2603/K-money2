package com.example.hector.k_money;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andres on 13/10/2016.
 */

public class MiBaseDatos extends SQLiteOpenHelper{

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASEDATOS = "k-money";
    //sentencia para la creacion de una tabla
    private static final String TABLA_INGRESOS =  "CREATE TABLE ingresos" +
            "(id_ingresos INT PRIMARY KEY, titulo TEXT, descripcion TEXT, valor INT, fecha DATE)";

    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_INGRESOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLA_INGRESOS);
        onCreate(db);
    }
}
