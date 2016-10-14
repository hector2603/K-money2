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
import android.widget.TextView;
import android.widget.Toast;

public class VerEgreso extends AppCompatActivity {
    TextView titulo,descripcion,valor,fecha;
    Button Editar,Eliminar;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_egreso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        id = getIntent().getIntExtra("identificador",15);
        getSupportActionBar().setTitle("Ver Egreso ");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Holita", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // obteniendo los componentes de la vista
        titulo = (TextView) findViewById(R.id.ver_titulo_Egreso);
        descripcion = (TextView) findViewById(R.id.ver_descripcion_Egreso);
        valor = (TextView) findViewById(R.id.ver_valor_Egreso);
        fecha = (TextView) findViewById(R.id.ver_fecha_Egreso);
        Editar = (Button) findViewById(R.id.editar_Egreso);
        Eliminar = (Button) findViewById(R.id.eliminar_Egreso);
        // obteniendo el intent para los datos
        Intent cambio = getIntent();
        //Extrayendo el extra de tipo cadena
        String title = cambio.getStringExtra("titulo");
        String descrip = cambio.getStringExtra("descripcion");
        int val = cambio.getIntExtra("valor",0);
        String date = cambio.getStringExtra("fecha");
        // asignando valores a los campos
        titulo.setText(title);
        descripcion.setText(descrip);
        valor.setText(""+val);
        fecha.setText(date);
        //creando controlador para el oyente de los botonesde eliminar y editar
        ControladorEgreso controlador = new ControladorEgreso(this);
        //asignando el oyente
        Editar.setOnClickListener(controlador);
        Eliminar.setOnClickListener(controlador);
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
            Intent cambio = new Intent(VerEgreso.this,Ingresos.class);
            startActivity(cambio);
            return true;
        }else if(id==R.id.Egreso){
            Toast.makeText(getApplicationContext(), "Egreso", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id==R.id.Deudas){
            Toast.makeText(getApplicationContext(), "Deuda", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getId(){
        return id;
    }

}