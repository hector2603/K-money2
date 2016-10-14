package com.example.hector.k_money;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Andres on 13/10/2016.
 */

public class ControladorEgreso implements View.OnClickListener{
    AppCompatActivity vista ;

    public ControladorEgreso(AppCompatActivity v){
        vista = v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.consultar_egreso){

        }
    }
}
