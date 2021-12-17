package com.grupo2.agrosoft.data.entity;

public class Parcelas {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private Integer ancho;
    private Integer largo;
    private Integer dimension_met2;
    private String estatus;

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

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;}

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getDimension_met2() {
        return dimension_met2;
    }

    public void setDimension_met2(Integer dimension_met2) {
        this.dimension_met2 = dimension_met2;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Parcelas(String nombre, String descripcion, String ubicacion, Integer ancho,
                    Integer largo, Integer dimension_met2, String estatus) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.largo = largo;
        this.dimension_met2 = dimension_met2;
        this.estatus = estatus;
    }

    public Parcelas() {
    }

}
