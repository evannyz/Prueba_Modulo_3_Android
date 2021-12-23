package com.evannyz.pruebamodulotresapplication.data.model;

public class Productos {
    private String nombre ;
    private String ingredientes;
    private Integer precio;
    private boolean isSelected;

    public Productos(String nombre, String ingredientes, Integer precio, Boolean isSelected) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.isSelected=isSelected;
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
