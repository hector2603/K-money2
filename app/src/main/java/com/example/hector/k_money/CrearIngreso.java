package com.example.hector.k_money;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearIngreso extends AppCompatActivity {
    EditText titulo;
    EditText descripcion;
    EditText valor;
    EditText fecha;
    Button crear;
    ControladorIngresos controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ingreso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //obteniendo componentes de la vista
        titulo = (EditText) findViewById(R.id.titulo_ingreso);
        descripcion = (EditText) findViewById(R.id.descripcion_ingreso);
        valor = (EditText) findViewById(R.id.valor_ingreso);
        fecha = (EditText) findViewById(R.id.fecha_ingreso);
        //obteniendo intent para determinar si es crear o modificar
        Intent datos = getIntent();
        if(datos.getStringExtra("tipo").equals("crear")){
            getSupportActionBar().setTitle("Crear Ingreso");
        }else{
            getSupportActionBar().setTitle("Modificar Ingreso ");
            titulo.setText(datos.getStringExtra("titulo"));
            descripcion.setText(datos.getStringExtra("descripcion"));
            valor.setText(datos.getStringExtra("valor"));
            fecha.setText(datos.getStringExtra("fecha"));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        OyenteBonton oyFab = new OyenteBonton(this);
        fab.setOnClickListener(oyFab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Creando controlador
        controlador = new ControladorIngresos(this);
        //obteniendo componentes de la vista
        crear = (Button) findViewById(R.id.create_ingreso);
        crear.setOnClickListener(controlador);

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
            Intent cambio = new Intent(CrearIngreso.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Intent cambio = new Intent(CrearIngreso.this,Egresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Deudas){
            Toast.makeText(getApplicationContext(), "Deuda", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
