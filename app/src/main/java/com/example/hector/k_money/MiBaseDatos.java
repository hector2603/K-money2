package com.example.hector.k_money;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 13/10/2016.
 */

public class MiBaseDatos extends SQLiteOpenHelper{

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASEDATOS = "k-money";
    //sentencia para la creacion de una tabla
    private static final String TABLA_INGRESOS =  "CREATE TABLE ingresos" +
            "(id_ingresos INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, descripcion TEXT, valor INT, fecha DATE)";

    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_INGRESOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST ingresos");
        onCreate(db);
    }

    public void insertarIngreso(String titulo, String descripcion, int valor, String fecha){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            //valores.put("id_ingresos", id);
            valores.put("titulo", titulo);
            valores.put("descripcion", descripcion);
            valores.put("valor", valor);
            valores.put("fecha", fecha);
            db.insert("ingresos", null, valores);
            db.close();
        }
    }

    public ArrayList<DatoIngreso> consultarIngresos(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<DatoIngreso> listaIngresos = new ArrayList<DatoIngreso>();
        String[] valores_recuperar = {"id_ingresos","titulo","descripcion","valor","fecha"};
        Cursor c = db.query("ingresos", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do{
            DatoIngreso datoIngreso = new DatoIngreso(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3),
                    c.getString(4));
            listaIngresos.add(datoIngreso);
        } while(c.moveToNext());
        db.close();
        c.close();
        return listaIngresos;
    }

    public void modificarIngreso(int id, String titulo, String descripcion, int valor, String fecha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_ingresos", id);
        valores.put("titulo", titulo);
        valores.put("descripcion", descripcion);
        valores.put("valor", valor);
        valores.put("fecha", fecha);
        db.update("ingresos", valores, "id_ingreso="+id, null);
        db.close();
    }

    public void borrarIngreso(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("ingresos", "id_ingresos="+id, null);
        db.close();
    }
}
