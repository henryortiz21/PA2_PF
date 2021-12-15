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
    public Integer getTiempo_cosecha() {
        return tiempocosechadias;
    }
    public void setTiempo_cosecha(Integer tiempo_cosecha) {
        this.tiempocosechadias = tiempo_cosecha;
    }
    public Integer getProduccio_por_metro2() {
        return producto_x_metro2;
    }
    public void setProduccio_por_metro2(Integer produccio_por_metro2) {
        this.producto_x_metro2 = produccio_por_metro2;
    }
    public String getUnidad_peso() {
        return unidadpeso;
    }
    public void setUnidad_peso(String unidad_peso) {
        this.unidadpeso = unidad_peso;
    }
    public Semilla(String nombre, Integer tiempo_cosecha, Integer produccio_por_metro2, String unidad_peso) {
        this.nombre = nombre;
        this.tiempocosechadias = tiempo_cosecha;
        this.producto_x_metro2 = produccio_por_metro2;
        this.unidadpeso = unidad_peso;
    }
    public Semilla() {
    }
    
}
