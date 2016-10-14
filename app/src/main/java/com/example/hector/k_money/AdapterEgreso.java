package com.example.hector.k_money;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hector on 13/10/2016.
 */
public class AdapterEgreso extends ArrayAdapter<DatoEgreso> {
    Context con;
    List<DatoEgreso> lista;
    public AdapterEgreso(Context context, List<DatoEgreso> objects) {
        super(context,0, objects);
        lista = objects;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public DatoEgreso getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_ingreso,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView title = (TextView) convertView.findViewById(R.id.list_titulo);
        TextView valor = (TextView) convertView.findViewById(R.id.list_valor);
        TextView fecha = (TextView) convertView.findViewById(R.id.list_fecha);

        // Lead actual.
        DatoEgreso dato = getItem(position);

        // Setup.
        title.setText(dato.getTitulo());
        valor.setText(""+dato.getValor());
        fecha.setText(dato.getFecha());

        return convertView;
    }
}
