package com.example.hector.k_money;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Deudas extends AppCompatActivity implements View.OnClickListener{
    Button crear, consultar;
    ControladorDeudas controlador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Creando controlador
        controlador = new ControladorDeudas(this);

        //obteniendo componentes de la ventana
        crear = (Button) findViewById(R.id.crear_Deuda);
        consultar = (Button) findViewById(R.id.Consultar_Deudas);
        crear.setOnClickListener(this);
        consultar.setOnClickListener(controlador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        OyenteBonton oyFab = new OyenteBonton(this);
        fab.setOnClickListener(oyFab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
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
            Intent cambio = new Intent(Deudas.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Intent cambio = new Intent(Deudas.this,Egresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Deudas){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id== R.id.crear_Deuda){
            Intent cambio = new Intent(Deudas.this, CrearDeuda.class);
            cambio.putExtra("tipo","crear");
            startActivity(cambio);
        }


    }
}
