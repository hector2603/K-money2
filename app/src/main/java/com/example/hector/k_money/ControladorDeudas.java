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
 * Created by hector on 14/10/2016.
 */
public class ControladorDeudas implements View.OnClickListener, AdapterView.OnItemClickListener {
    AppCompatActivity vista;
    EditText titulo, descripcion,valor,fecha,nombre;
    MiBaseDatos MDB ;

    public ControladorDeudas(AppCompatActivity v) {
        MDB = new MiBaseDatos(v.getApplicationContext());
        vista = v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.create_Deuda){
            titulo = (EditText) vista.findViewById(R.id.TituloDeudas);
            descripcion = (EditText) vista.findViewById(R.id.descripcion_Deudas);
            valor = (EditText) vista.findViewById(R.id.valor_Deudas);
            fecha = (EditText) vista.findViewById(R.id.fecha_Deudas);
            nombre = (EditText) vista.findViewById(R.id.NombresPrestadorDeudas);
            String datos = ""+titulo.getText().toString()+"  "+valor.getText().toString()+"  "+fecha.getText().toString()+" fin";
            if(titulo.getText().toString().equals("") || valor.getText().toString().equals("") || fecha.getText().toString().equals("")){
                Toast.makeText(vista.getApplicationContext(), "Faltan Datos "+datos, Toast.LENGTH_SHORT).show();
            }else{
                if(vista.getIntent().getStringExtra("tipo").equals("crear")){
                    Toast.makeText(vista.getApplicationContext(), "Creado", Toast.LENGTH_SHORT).show();
                    MDB.insertarDeuda(titulo.getText().toString(),nombre.getText().toString(), descripcion.getText().toString(), Integer.parseInt(valor.getText().toString()), fecha.getText().toString());
                    Intent cambio = new Intent(vista, ConsultarDeudas.class);
                    ArrayList<DatoDeudas> deuda_list = MDB.consultarDeudas();
                    cambio.putExtra("datos", deuda_list);
                    vista.startActivity(cambio);
                }else if(vista.getIntent().getStringExtra("tipo").equals("modificar")){
                    int identificador = vista.getIntent().getIntExtra("identificadorModi",20);
                    Intent cambio = new Intent(vista, ConsultarDeudas.class);
                    //.makeText(vista.getApplicationContext(), "Modificado  "+identificador, Toast.LENGTH_SHORT).show();
                    MDB.modificarDeudas(identificador,titulo.getText().toString(),nombre.getText().toString(), descripcion.getText().toString(), Integer.parseInt(valor.getText().toString()), fecha.getText().toString());
                    ArrayList<DatoDeudas> deuda_list = MDB.consultarDeudas();
                    cambio.putExtra("datos", deuda_list);
                    vista.startActivity(cambio);
                }else{
                    Toast.makeText(vista.getApplicationContext(), "No pasa nada", Toast.LENGTH_SHORT).show();
                }

            }

        }else if(id==R.id.Consultar_Deudas){

            Intent cambio = new Intent(vista, ConsultarDeudas.class);
            ArrayList<DatoDeudas> deuda_list = MDB.consultarDeudas();
            cambio.putExtra("datos", deuda_list);
            vista.startActivity(cambio);

        }else if(id==R.id.editar_Deuda){
            Intent cambio = new Intent(vista, CrearDeuda.class);
            VerDeuda vistica = (VerDeuda) vista;
            int identificador = vistica.getId();
            //obteniendo componentes de la vista para obtener datos
            TextView title = (TextView)vista.findViewById(R.id.ver_titulo_Deuda);
            TextView descrip = (TextView)vista.findViewById(R.id.ver_descripcion_Deuda);
            TextView val = (TextView)vista.findViewById(R.id.ver_valor_Deuda);
            TextView date = (TextView)vista.findViewById(R.id.ver_fecha_Deuda);
            TextView name = (TextView)vista.findViewById(R.id.ver_nombre_Deuda);
            //mandando datos a la vista siguiente
            cambio.putExtra("titulo",title.getText().toString());
            cambio.putExtra("descripcion",descrip.getText().toString());
            cambio.putExtra("valor",val.getText().toString());
            cambio.putExtra("fecha",date.getText().toString());
            cambio.putExtra("nombre",name.getText().toString());
            cambio.putExtra("identificadorModi",identificador);
            cambio.putExtra("tipo","modificar");
            vista.startActivity(cambio);
        }else if(id==R.id.eliminar_Deuda){
            VerDeuda vistica = (VerDeuda)vista;
            int identificador = vistica.getId();
            MDB.borrarDeudas(identificador);
            Toast.makeText(vista.getApplicationContext(), "Egreso eliminado "+identificador, Toast.LENGTH_SHORT).show();

            Intent cambio = new Intent(vista, ConsultarDeudas.class);
            ArrayList<DatoDeudas> deuda_list = MDB.consultarDeudas();
            cambio.putExtra("datos", deuda_list);
            vista.startActivity(cambio);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DatoDeudas actual = (DatoDeudas) parent.getItemAtPosition(position);
        /*Toast.makeText(view.getContext(),
                "Iniciar screen de detalle para: \n" + actual.getTitulo(),
                Toast.LENGTH_SHORT).show();*/

        Intent cambio = new Intent(vista, VerDeuda.class);
        int id_ingre = actual.getId();
        cambio.putExtra("identificador",id_ingre);
        cambio.putExtra("titulo", actual.getTitulo());
        cambio.putExtra("descripcion", actual.getDescripcion());
        cambio.putExtra("valor", actual.getValor());
        cambio.putExtra("fecha", actual.getFechaPago());
        cambio.putExtra("nombre",actual.getNombrePrestador());
        vista.startActivity(cambio);
    }


}