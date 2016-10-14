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
    private static final String TABLA_EGRESOS =  "CREATE TABLE egresos" +
            "(id_egresos INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, descripcion TEXT, valor INT, fecha DATE)";
    private static final String TABLA_DEUDAS =  "CREATE TABLE deudas" +
            "(id_deudas INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, nombrePrestador TEXT, descripcion TEXT, " +
            "valor INT, fechaPago DATE)";

    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_DEUDAS);
        db.execSQL(TABLA_EGRESOS);
        db.execSQL(TABLA_INGRESOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " +TABLA_DEUDAS);
        db.execSQL("DROP TABLE IF EXIST " +TABLA_INGRESOS);
        db.execSQL("DROP TABLE IF EXIST " +TABLA_EGRESOS);
        onCreate(db);
    }

    // CRUD PARA INGRESO

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
        db.update("ingresos", valores, "id_ingresos="+id, null);
        db.close();
    }

    public void borrarIngreso(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("ingresos", "id_ingresos="+id, null);
        db.close();
    }

    // CRUD PARA EGRESO

    public void insertarEgreso(String titulo, String descripcion, int valor, String fecha){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            //valores.put("id_ingresos", id);
            valores.put("titulo", titulo);
            valores.put("descripcion", descripcion);
            valores.put("valor", valor);
            valores.put("fecha", fecha);
            db.insert("egresos", null, valores);
            db.close();
        }
    }

    public ArrayList<DatoEgreso> consultarEgresos(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<DatoEgreso> listaEgresos = new ArrayList<DatoEgreso>();
        String[] valores_recuperar = {"id_egresos","titulo","descripcion","valor","fecha"};
        Cursor c = db.query("egresos", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do{
            DatoEgreso datoEgreso = new DatoEgreso(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3),
                    c.getString(4));
            listaEgresos.add(datoEgreso);
        } while(c.moveToNext());
        db.close();
        c.close();
        return listaEgresos;
    }

    public void modificarEgreso(int id, String titulo, String descripcion, int valor, String fecha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_egresos", id);
        valores.put("titulo", titulo);
        valores.put("descripcion", descripcion);
        valores.put("valor", valor);
        valores.put("fecha", fecha);
        db.update("egresos", valores, "id_egresos="+id, null);
        db.close();
    }

    public void borrarEgreso(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("egresos", "id_egresos="+id, null);
        db.close();
    }

    //CRUD PARA DEUDAS

    public void insertarDeuda(String titulo, String nombrePrestador, String descripcion, int valor, String fechaPago){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            //valores.put("id_ingresos", id);
            valores.put("titulo", titulo);
            valores.put("nombrePrestador", nombrePrestador);
            valores.put("descripcion", descripcion);
            valores.put("valor", valor);
            valores.put("fechaPago", fechaPago);
            db.insert("deudas", null, valores);
            db.close();
        }
    }

    public ArrayList<DatoDeudas> consultarDeudas(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<DatoDeudas> listaDeudas = new ArrayList<DatoDeudas>();
        String[] valores_recuperar = {"id_deudas","titulo", "nombrePrestador", "descripcion","valor","fechaPago"};
        Cursor c = db.query("deudas", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do{
            DatoDeudas datoDeuda = new DatoDeudas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4),
                    c.getString(5));
            listaDeudas.add(datoDeuda);
        } while(c.moveToNext());
        db.close();
        c.close();
        return listaDeudas;
    }

    public void modificarDeudas(int id, String titulo, String nombrePrestador, String descripcion, int valor, String fecha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_deudas", id);
        valores.put("titulo", titulo);
        valores.put("nombrePrestador",nombrePrestador);
        valores.put("descripcion", descripcion);
        valores.put("valor", valor);
        valores.put("fechaPago", fecha);
        db.update("deudas", valores, "id_deudas="+id, null);
        db.close();
    }

    public void borrarDeudas(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("deudas", "id_deudas="+id, null);
        db.close();
    }

    //CONSULTAS PROPIAS

    public String ingresos(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT sum(valor) AS TotalIngresos FROM ingresos", null);
        String result = null;
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registro
            try {
                result= c.getString(0);
                c.close();
            }catch (Exception o){
                result= "0";
            }
        }else{
            result = "NADA";
        }
        db.close();
        return result;
    }

    public String egresos(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT sum(valor) AS TotalEgresos FROM egresos", null);
        String result = null;
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registro
            try {
                result= c.getString(0);
                c.close();
            }catch (Exception o){
                result= "0";
            }
        }else{
            result = "NADA";
        }
        db.close();
        return result;
    }
}
