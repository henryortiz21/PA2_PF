package com.grupo2.agrosoft.data.entity;

public class Semilla {
    private Integer id;
    private String nombre;
    private Integer tiempo_cosecha;
    private Integer produccio_por_metro2;
    private String unidad_peso;
    
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
        return tiempo_cosecha;
    }
    public void setTiempo_cosecha(Integer tiempo_cosecha) {
        this.tiempo_cosecha = tiempo_cosecha;
    }
    public Integer getProduccio_por_metro2() {
        return produccio_por_metro2;
    }
    public void setProduccio_por_metro2(Integer produccio_por_metro2) {
        this.produccio_por_metro2 = produccio_por_metro2;
    }
    public String getUnidad_peso() {
        return unidad_peso;
    }
    public void setUnidad_peso(String unidad_peso) {
        this.unidad_peso = unidad_peso;
    }
    public Semilla(String nombre, Integer tiempo_cosecha, Integer produccio_por_metro2, String unidad_peso) {
        this.nombre = nombre;
        this.tiempo_cosecha = tiempo_cosecha;
        this.produccio_por_metro2 = produccio_por_metro2;
        this.unidad_peso = unidad_peso;
    }
    public Semilla() {
    }
    
}
