package com.grupo2.agrosoft.data.entity;

public class Semilla {
    private Integer id;
    private String nombre;
    private Integer tiempocosechadias;
    private Integer producto_x_metro2;
    private String unidadpeso;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getTiempocosechadias() {
        return tiempocosechadias;
    }
    public void setTiempocosechadias(Integer tiempocosechadias) {
        this.tiempocosechadias = tiempocosechadias;
    }
    public Integer getProducto_x_metro2() {
        return producto_x_metro2;
    }
    public void setProducto_x_metro2(Integer producto_x_metro2) {
        this.producto_x_metro2 = producto_x_metro2;
    }
    public String getUnidadpeso() {
        return unidadpeso;
    }
    public void setUnidadpeso(String unidadpeso) {
        this.unidadpeso = unidadpeso;
    }
    public Semilla(String nombre, Integer tiempocosechadias, Integer producto_x_metro2, String unidadpeso) {
        this.nombre = nombre;
        this.tiempocosechadias = tiempocosechadias;
        this.producto_x_metro2 = producto_x_metro2;
        this.unidadpeso = unidadpeso;
    }
    public Semilla() {
    }
}
