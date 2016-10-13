package com.example.hector.k_money;

/**
 * Created by hector on 13/10/2016.
 */

public class DatoIngreso {


    String id;
    String titulo;
    String descripcion;
    String valor;
    String fecha;
    public DatoIngreso(String i,String t,String v,String f){
        titulo = t;
        valor = v;
        fecha = f;
        id = i;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public String getValor() {
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

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
