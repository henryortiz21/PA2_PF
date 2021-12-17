package com.grupo2.agrosoft.data.entity;

public class RegistroSiembras {
    private Integer id;
    private String codigo;
    private String tiposiembra;
    private String parcela;
    private String descripcion;
    private String ubicacion;
    private Integer dimension_met2;
    private Integer producto_x_met2;
    private String fechasiembra;
    private String fecha_cosecha;
    private Integer cantidadaproximacosechar;
    private String estatus;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Integer getDimension_met2() {
        return dimension_met2;
    }
    public void setDimension_met2(Integer dimension_met2) {
        this.dimension_met2 = dimension_met2;
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

    public String getFecha_cosecha() {
        return fecha_cosecha;
    }
    public void setFecha_cosecha(String fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
    }

    public Integer getCantidadaproximacosechar() {
        return cantidadaproximacosechar;
    }
    public void setCantidadaproximacosechar(Integer cantidadaproximacosechar) {
        this.cantidadaproximacosechar = cantidadaproximacosechar;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getParcela() {
        return parcela;
    }
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Integer getProducto_x_met2() {
        return producto_x_met2;
    }
    public void setProducto_x_met2(Integer producto_x_met2) {
        this.producto_x_met2 = producto_x_met2;
    }

    public RegistroSiembras(String codigo, String tiposiembra, String parcela,String descripcion,
                            String ubicacion, Integer dimension_met2, Integer producto_x_met2,
                            String fechasiembra, String fecha_cosecha,
                            Integer cantidadaproximacosechar, String estatus) {
        this.codigo = codigo;
        this.tiposiembra = tiposiembra;
        this.parcela = parcela;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dimension_met2 = dimension_met2;
        this.producto_x_met2 = producto_x_met2;
        this.fechasiembra = fechasiembra;
        this.fecha_cosecha = fecha_cosecha;
        this.cantidadaproximacosechar = cantidadaproximacosechar;
        this.estatus = estatus;
    }
    public RegistroSiembras() {
    }}
