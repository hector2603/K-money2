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
import android.widget.EditText;
import android.widget.Toast;

public class CrearDeuda extends AppCompatActivity {
    EditText titulo;
    EditText descripcion;
    EditText valor;
    EditText fecha;
    EditText nombre;
    Button crear;
    ControladorDeudas controlador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_deuda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //obteniendo componentes de la vista
        titulo = (EditText) findViewById(R.id.TituloDeudas);
        descripcion = (EditText) findViewById(R.id.descripcion_Deudas);
        valor = (EditText) findViewById(R.id.valor_Deudas);
        fecha = (EditText) findViewById(R.id.fecha_Deudas);
        nombre = (EditText) findViewById(R.id.NombresPrestadorDeudas);
        //obteniendo intent para determinar si es crear o modificar
        Intent datos = getIntent();
        if(datos.getStringExtra("tipo").equals("crear")){
            getSupportActionBar().setTitle("Crear Deuda");
        }else{
            getSupportActionBar().setTitle("Modificar Deuda ");
            titulo.setText(datos.getStringExtra("titulo"));
            descripcion.setText(datos.getStringExtra("descripcion"));
            valor.setText(datos.getStringExtra("valor"));
            fecha.setText(datos.getStringExtra("fecha"));
            nombre.setText(datos.getStringExtra("nombre"));
        }
        //Creando controlador
        controlador = new ControladorDeudas(this);
        //obteniendo componentes de la vista
        crear = (Button) findViewById(R.id.create_Deuda);
        crear.setOnClickListener(controlador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
            Intent cambio = new Intent(CrearDeuda.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Intent cambio = new Intent(CrearDeuda.this,Egresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Deudas){
            Intent cambio = new Intent(CrearDeuda.this,Deudas.class);
            startActivity(cambio);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
