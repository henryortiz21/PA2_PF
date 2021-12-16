package com.grupo2.agrosoft.data.entity;

public class Siembra {
    private Integer id;
    private String descripcion;
    private String ubicacion;
    private Integer dimensiones;// En mt2
    private String tiposiembra;
    private String fechasiembra;
    private String fecha_cosechaendias1;
    private Integer cantidadaproximacosechar;
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
    public String getTiposiembra() {
        return tiposiembra;
    }
    public void setTiposiembra(String tiposiembra) {
        this.tiposiembra = tiposiembra;
    }
    public String getFechasiembra() {
        return fechasiembra;
    }
    public void setFechasiembra(String fechasiembra) {
        this.fechasiembra = fechasiembra;
    }
    public String getFecha_cosechaendias1() {
        return fecha_cosechaendias1;
    }
    public void setFecha_cosechaendias1(String fecha_cosechaendias1) {
        this.fecha_cosechaendias1 = fecha_cosechaendias1;
    }
    public Integer getCantidadaproximacosechar() {
        return cantidadaproximacosechar;
    }
    public void setCantidadaproximacosechar(Integer cantidadaproximacosechar) {
        this.cantidadaproximacosechar = cantidadaproximacosechar;
    }
    public Siembra(String descripcion, String ubicacion, Integer dimensiones, String tiposiembra, String fechasiembra,
            String fecha_cosechaendias1, Integer cantidadaproximacosechar) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dimensiones = dimensiones;
        this.tiposiembra = tiposiembra;
        this.fechasiembra = fechasiembra;
        this.fecha_cosechaendias1 = fecha_cosechaendias1;
        this.cantidadaproximacosechar = cantidadaproximacosechar;
    }
    public Siembra() {
    }


}
