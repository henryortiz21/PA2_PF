package com.grupo2.agrosoft.data.entity;

public class Siembra {
    private Integer id;
    private String descripcion;
    private String ubicacion;
    private Integer dimensiones;// En mt2
    private String tipo_siembra;
    private String fecha_siembra;
    private String fecha_cosecha1;
    private String cosecha_aproximada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Integer dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getTipo_siembra() {
        return tipo_siembra;
    }

    public void setTipo_siembra(String tipo_siembra) {
        this.tipo_siembra = tipo_siembra;
    }

    public String getFecha_siembra() {
        return fecha_siembra;
    }

    public void setFecha_siembra(String fecha_siembra) {
        this.fecha_siembra = fecha_siembra;
    }

    public String getFecha_cosecha1() {
        return fecha_cosecha1;
    }

    public void setFecha_cosecha1(String fecha_cosecha1) {
        this.fecha_cosecha1 = fecha_cosecha1;
    }

    public String getCosecha_aproximada() {
        return cosecha_aproximada;
    }

    public void setCosecha_aproximada(String cosecha_aproximada) {
        this.cosecha_aproximada = cosecha_aproximada;
    }

    public Siembra(String descripcion, String ubicacion, Integer dimensiones, String tipo_siembra, String fecha_siembra,
            String fecha_cosecha1, String cosecha_aproximada) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dimensiones = dimensiones;
        this.tipo_siembra = tipo_siembra;
        this.fecha_siembra = fecha_siembra;
        this.fecha_cosecha1 = fecha_cosecha1;
        this.cosecha_aproximada = cosecha_aproximada;
    }

    public Siembra() {
    }
}
