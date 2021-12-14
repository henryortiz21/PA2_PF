package com.grupo2.agrosoft.data.entity;

public class Siembra {
    private Integer id;
    private String descripcion;
    private String ubicacion;
    private String dimensiones;
    private String tipo_siembra;
    private String fecha_siembra;
    private String fecha_cosecha;

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

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
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

    public String getFecha_cosecha() {
        return fecha_cosecha;
    }

    public void setFecha_cosecha(String fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
    }

    public Siembra(String descripcion, String ubicacion, String dimensiones, String tipo_siembra, String fecha_siembra,
            String fecha_cosecha) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dimensiones = dimensiones;
        this.tipo_siembra = tipo_siembra;
        this.fecha_siembra = fecha_siembra;
        this.fecha_cosecha = fecha_cosecha;
    }
}
