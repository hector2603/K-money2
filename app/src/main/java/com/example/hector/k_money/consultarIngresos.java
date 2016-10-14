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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class consultarIngresos extends AppCompatActivity {
    ListView listaIngresos;
    AdapterIngreso datos;
    ControladorIngresos controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_ingresos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Consultar Ingresos");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Obteniendo componentes de la vista
        listaIngresos = (ListView) findViewById(R.id.lista_ingresos);
        // creando intent para recibir los datos del controlador
        Intent cambio = getIntent();
        // recibir el rray list del controlador con todos los datos
        ArrayList<DatoIngreso> ingresos_list = (ArrayList<DatoIngreso>) cambio.getSerializableExtra("datos");
        // al listview le asigna el adepter con la lista
        datos = new AdapterIngreso(this,ingresos_list);
        listaIngresos.setAdapter(datos);
        //a la lista le asigna el oyente, que sera controlador
        controlador = new ControladorIngresos(this);
        listaIngresos.setOnItemClickListener(controlador);
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
            Intent cambio = new Intent(consultarIngresos.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Intent cambio = new Intent(consultarIngresos.this,Egresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Deudas){
            Intent cambio = new Intent(consultarIngresos.this,Deudas.class);
            startActivity(cambio);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
