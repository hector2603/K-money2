package com.example.hector.k_money;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hector on 12/10/2016.
 */

public class ControladorIngresos implements View.OnClickListener,AdapterView.OnItemClickListener{

    AppCompatActivity vista;
    EditText titulo, descripcion,valor,fecha;

    public ControladorIngresos(AppCompatActivity v){
        vista = v;
    }

    public void crear(String titulo, String descripcion, double valor, String fecha, AppCompatActivity ingresos){
        if(titulo!= "" && valor != 0 && fecha != ""){
            Toast.makeText(ingresos.getApplicationContext(), "Datos correctos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ingresos.getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.create_ingreso){
            titulo = (EditText) vista.findViewById(R.id.titulo_ingreso);
            descripcion = (EditText) vista.findViewById(R.id.descripcion_ingreso);
            valor = (EditText) vista.findViewById(R.id.valor_ingreso);
            fecha = (EditText) vista.findViewById(R.id.fecha_ingreso);
            String datos = ""+titulo.getText().toString()+"  "+valor.getText().toString()+"  "+fecha.getText().toString()+" fin";
            if(titulo.getText().toString().equals("") || valor.getText().toString().equals("") || fecha.getText().toString().equals("")){
                Toast.makeText(vista.getApplicationContext(), "Faltan Datos "+datos, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(vista.getApplicationContext(), "Datos correctos"+datos, Toast.LENGTH_SHORT).show();
                //AQUÍ ira la creacion en la BD
                Intent cambio = new Intent(vista, VerIngreso.class);
                cambio.putExtra("titulo",titulo.getText().toString());
                cambio.putExtra("descripcion",descripcion.getText().toString());
                cambio.putExtra("valor",valor.getText().toString());
                cambio.putExtra("fecha",fecha.getText().toString());
                vista.startActivity(cambio);
            }

        }else if(id==R.id.consultar_ingreso){

            Intent cambio = new Intent(vista, consultarIngresos.class);
            ArrayList<DatoIngreso> ingresos_list = new ArrayList<DatoIngreso>();
            ingresos_list.add(new DatoIngreso("1","empanadas ricas","500","5-5-5"));
            ingresos_list.add(new DatoIngreso("2","empanadas ricas2","600","6-5-5"));
            ingresos_list.add(new DatoIngreso("3","empanadas ricas3","700","7-5-5"));
            cambio.putExtra("datos",ingresos_list);
            vista.startActivity(cambio);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DatoIngreso actual = (DatoIngreso) parent.getItemAtPosition(position);
        Toast.makeText(view.getContext(),
                "Iniciar screen de detalle para: \n" + actual.getTitulo(),
                Toast.LENGTH_SHORT).show();

        Intent cambio = new Intent(vista, VerIngreso.class);
        String id_ingre = actual.getId();
        cambio.putExtra("titulo",actual.getTitulo());
        cambio.putExtra("descripcion",actual.getDescripcion());
        cambio.putExtra("valor",actual.getValor());
        cambio.putExtra("fecha",actual.getFecha());
        vista.startActivity(cambio);
    }


}
