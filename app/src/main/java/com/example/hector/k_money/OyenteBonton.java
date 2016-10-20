package com.example.hector.k_money;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hector on 19/10/2016.
 */

public class OyenteBonton implements View.OnClickListener {

    AppCompatActivity vista;

    public OyenteBonton(AppCompatActivity v){
        vista = v;
    }

    @Override
    public void onClick(View v) {
        Intent cambio = new Intent(vista,Inicio.class);
        vista.startActivity(cambio);
    }
}
