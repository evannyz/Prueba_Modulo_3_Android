package com.evannyz.pruebamodulotresapplication.data.model;

public class Productos {
    private String urlImagenProducto;
    private String nombre ;
    private String ingredientes;
    private int precio;
    private boolean isSelected;

    public Productos(String urlImagenProducto, String nombre, String ingredientes, Integer precio, Boolean isSelected){
        this.urlImagenProducto = urlImagenProducto;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.isSelected=isSelected;
    }

    public String getUrlImagenProducto() {
        return urlImagenProducto;
    }

    public void setUrlImagenProducto(String urlImagenProducto) {
        this.urlImagenProducto = urlImagenProducto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
