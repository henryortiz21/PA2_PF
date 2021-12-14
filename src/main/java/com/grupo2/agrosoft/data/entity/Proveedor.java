package com.grupo2.agrosoft.data.entity;

public class Proveedor {
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String web;
    private String logo;

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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    

    
    public Proveedor() {
    }
    public Proveedor(String nombre, String telefono, String direccion, String web, String logo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.web = web;
        this.logo = logo;
    }
}
