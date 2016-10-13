package com.example.hector.k_money;

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

        ArrayList<DatoIngreso> ingresos_list = new ArrayList<DatoIngreso>();
        ingresos_list.add(new DatoIngreso("1","empanadas ricas","500","5-5-5"));
        ingresos_list.add(new DatoIngreso("2","empanadas ricas2","600","6-5-5"));
        ingresos_list.add(new DatoIngreso("3","empanadas ricas3","700","7-5-5"));
        datos = new AdapterIngreso(this,ingresos_list);
        listaIngresos.setAdapter(datos);
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

}
