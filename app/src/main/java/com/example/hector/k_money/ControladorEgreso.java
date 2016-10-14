package com.example.hector.k_money;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Andres on 13/10/2016.
 */

public class ControladorEgreso implements View.OnClickListener,AdapterView.OnItemClickListener{
    AppCompatActivity vista;
    EditText titulo, descripcion,valor,fecha;
    MiBaseDatos MDB ;

    public ControladorEgreso(AppCompatActivity v){
        MDB = new MiBaseDatos(v.getApplicationContext());
        vista = v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.create_egreso){
            titulo = (EditText) vista.findViewById(R.id.titulo_Egreso);
            descripcion = (EditText) vista.findViewById(R.id.descripcion_Egreso);
            valor = (EditText) vista.findViewById(R.id.valor_Egreso);
            fecha = (EditText) vista.findViewById(R.id.fecha_Egreso);
            String datos = ""+titulo.getText().toString()+"  "+valor.getText().toString()+"  "+fecha.getText().toString()+" fin";
            if(titulo.getText().toString().equals("") || valor.getText().toString().equals("") || fecha.getText().toString().equals("")){
                Toast.makeText(vista.getApplicationContext(), "Faltan Datos "+datos, Toast.LENGTH_SHORT).show();
            }else{
                if(vista.getIntent().getStringExtra("tipo").equals("crear")){
                    Toast.makeText(vista.getApplicationContext(), "Creado", Toast.LENGTH_SHORT).show();
                    //MDB.insertarIngreso(titulo.getText().toString(), descripcion.getText().toString(), Integer.parseInt(valor.getText().toString()), fecha.getText().toString());
                    Intent cambio = new Intent(vista, ConsultarEgreso.class);
                    //ArrayList<DatoIngreso> ingresos_list = MDB.consultarIngresos();
                    //cambio.putExtra("datos",ingresos_list);
                    vista.startActivity(cambio);
                }else if(vista.getIntent().getStringExtra("tipo").equals("modificar")){
                    int identificador = vista.getIntent().getIntExtra("identificadorModi",20);
                    Intent cambio = new Intent(vista, ConsultarEgreso.class);
                    //.makeText(vista.getApplicationContext(), "Modificado  "+identificador, Toast.LENGTH_SHORT).show();
                    //MDB.modificarIngreso(identificador,titulo.getText().toString(), descripcion.getText().toString(), Integer.parseInt(valor.getText().toString()), fecha.getText().toString());
                    //ArrayList<DatoIngreso> ingresos_list = MDB.consultarIngresos();
                    //cambio.putExtra("datos",ingresos_list);
                    vista.startActivity(cambio);
                }else{
                    Toast.makeText(vista.getApplicationContext(), "No pasa nada", Toast.LENGTH_SHORT).show();
                }

            }

        }else if(id==R.id.consultar_egreso){

            Intent cambio = new Intent(vista, ConsultarEgreso.class);
            //ArrayList<DatoIngreso> ingresos_list = MDB.consultarIngresos();
            ArrayList<DatoEgreso> egreso_list = new ArrayList<DatoEgreso>();
            egreso_list.add(new DatoEgreso(1,"empanaditas riquitas","empanadas ricas",500,"5-5-5"));
            egreso_list.add(new DatoEgreso(2,"empanadas malucas","empanadas ricas2",600,"6-5-5"));
            egreso_list.add(new DatoEgreso(3,"La cuestion es de hambre","empanadas ricas3",700,"7-5-5"));
            cambio.putExtra("datos",egreso_list);
            vista.startActivity(cambio);

        }else if(id==R.id.editar_Egreso){
            Intent cambio = new Intent(vista, CrearEgreso.class);
            VerEgreso vistica = (VerEgreso) vista;
            int identificador = vistica.getId();
            //obteniendo componentes de la vista para obtener datos
            TextView title = (TextView)vista.findViewById(R.id.ver_titulo_Egreso);
            TextView descrip = (TextView)vista.findViewById(R.id.ver_descripcion_Egreso);
            TextView val = (TextView)vista.findViewById(R.id.ver_valor_Egreso);
            TextView date = (TextView)vista.findViewById(R.id.ver_fecha_Egreso);
            //mandando datos a la vista siguiente
            cambio.putExtra("titulo",title.getText().toString());
            cambio.putExtra("descripcion",descrip.getText().toString());
            cambio.putExtra("valor",val.getText().toString());
            cambio.putExtra("fecha",date.getText().toString());
            cambio.putExtra("identificadorModi",identificador);
            cambio.putExtra("tipo","modificar");
            vista.startActivity(cambio);
        }else if(id==R.id.eliminar_Egreso){
            VerEgreso vistica = (VerEgreso)vista;
            int identificador = vistica.getId();
            //MDB.borrarIngreso(identificador);
            Toast.makeText(vista.getApplicationContext(), "Ingreso eliminado", Toast.LENGTH_SHORT).show();

            //Intent cambio = new Intent(vista, ConsultarEgreso.class);
            //ArrayList<DatoIngreso> ingresos_list = MDB.consultarIngresos();
            //cambio.putExtra("datos",ingresos_list);
            //vista.startActivity(cambio);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DatoEgreso actual = (DatoEgreso) parent.getItemAtPosition(position);
        /*Toast.makeText(view.getContext(),
                "Iniciar screen de detalle para: \n" + actual.getTitulo(),
                Toast.LENGTH_SHORT).show();*/

        Intent cambio = new Intent(vista, VerEgreso.class);
        int id_ingre = actual.getId();
        cambio.putExtra("identificador",id_ingre);
        cambio.putExtra("titulo", actual.getTitulo());
        cambio.putExtra("descripcion", actual.getDescripcion());
        cambio.putExtra("valor", actual.getValor());
        cambio.putExtra("fecha", actual.getFecha());
        vista.startActivity(cambio);
    }


}