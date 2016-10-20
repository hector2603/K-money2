package com.example.hector.k_money;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        //Prueba de DB
        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        //MDB.insertarIngreso("HOLA3", "HOLADESCRI", 123546, "12/01/2016");
        //MDB.insertarEgreso("HOLA3", "HOLADESCRI", 123546, "12/01/2016");
        //MDB.insertarIngreso("HOLA3", "HOLADESCRI", 123546, "12/01/2016");
        //recuperar datos
        //MDB.borrarIngreso(0);
        /*int[] ids = new int[MDB.consultarIngresos().size()];
        for(int i=0; i < MDB.consultarIngresos().size(); i++){
            ids[i] = MDB.consultarIngresos().get(i).getId();
            Log.d("hola encontro uno",""+ids[i]);
        }*/

        //  aquí va el dinero
        TextView utilidad = (TextView) findViewById(R.id.Utilidad);
        int ingresos, egresos, utility;
        try{
            ingresos = Integer.parseInt(MDB.ingresos());
        }catch (Exception e){
            ingresos = 0;
        }
        try{
            egresos = Integer.parseInt(MDB.egresos());
        }catch (Exception io){
            egresos = 0;
        }
        utility = ingresos - egresos;
        String dinero = ""+utility;
        utilidad.setText("$ "+dinero);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Ingreso) {
            Intent cambio = new Intent(Inicio.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Intent cambio = new Intent(Inicio.this,Egresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Deudas){
            Intent cambio = new Intent(Inicio.this,Deudas.class);
            startActivity(cambio);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
