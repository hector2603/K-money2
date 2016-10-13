package com.example.hector.k_money;

import java.io.Serializable;

/**
 * Created by hector on 13/10/2016.
 */

public class DatoIngreso implements Serializable {


    int id;
    String titulo;
    String descripcion;
    int valor;
    String fecha;
    public DatoIngreso(int i,String t, String d, int v,String f){
        id = i;
        titulo = t;
        descripcion = d;
        valor = v;
        fecha = f;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public int getValor() {
        return valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
