package com.grupo2.agrosoft.data.entity;

public class ControlSiembra {
    private Integer id;
    private String codigo;
    private String tipo_siembra;
    private String riego;
    private String fertilizacion;
    private String aplicacioninsecticida;
    private String limpieza;

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

    public String getTipo_siembra() {
        return tipo_siembra;
    }
    public void setTipo_siembra(String tipo_siembra) {
        this.tipo_siembra = tipo_siembra;
    }

    public String getRiego() {
        return riego;
    }
    public void setRiego(String riego) {
        this.riego = riego;
    }

    public String getFertilizacion() {
        return fertilizacion;
    }
    public void setFertilizacion(String fertilizacion) {
        this.fertilizacion = fertilizacion;
    }

    public String getAplicacioninsecticida() {
        return aplicacioninsecticida;
    }
    public void setAplicacioninsecticida(String aplicacioninsecticida) {
        this.aplicacioninsecticida = aplicacioninsecticida;}

    public String getLimpieza() {
        return limpieza;
    }
    public void setLimpieza(String limpieza) {
        this.limpieza = limpieza;
    }

    public ControlSiembra(String codigo,String tipo_siembra, String riego, String fertilizacion
                        ,String aplicacioninsecticida, String limpieza) {
        this.codigo = codigo;
        this.tipo_siembra = tipo_siembra;
        this.riego = riego;
        this.fertilizacion = fertilizacion;
        this.aplicacioninsecticida = aplicacioninsecticida;
        this.limpieza = limpieza;
    }

    public ControlSiembra() {
    }
}
