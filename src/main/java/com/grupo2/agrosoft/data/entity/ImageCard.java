package com.grupo2.agrosoft.data.entity;

public class ImageCard {
    private String titulo;
    private String imagen;
    public ImageCard(String titulo, String imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
