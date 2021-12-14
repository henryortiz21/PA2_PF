package com.grupo2.agrosoft.data.entity;

public class Producto {
    private Integer id;
    private String nombre;
    private String presentacion;
    private String descripcion;
    private String proveedor;
    private String categoria;
    private String dosis;
    private String precio;
    private String imagen;

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

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Producto(String nombre, String presentacion, String descripcion, String proveedor,
            String categoria, String dosis, String precio, String imagen) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.dosis = dosis;
        this.precio = precio;
        this.imagen = imagen;
    }

}
