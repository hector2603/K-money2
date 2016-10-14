package com.example.hector.k_money;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by Andres on 14/10/2016.
 */

public class DatoDeudas  implements Serializable {

    int id;
    String titulo;
    String nombrePrestador;
    String descripcion;
    int valor;
    String fechaPago;

    public DatoDeudas(int i,String t, String nP, String d, int v, String f){
        id = i;
        titulo = t;
        nombrePrestador = nP;
        descripcion = d;
        valor = v;
        fechaPago = f;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombrePrestador() {
        return nombrePrestador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValor() {
        return valor;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombrePrestador(String nombrePrestador) {
        this.nombrePrestador = nombrePrestador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setFechaPago(String fecha) {
        this.fechaPago = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
