package com.evannyz.pruebamodulotresapplication.data.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeProductos {
   public static List<Productos> listaDeProductos() {
        List<Productos> listaDeProductos = new ArrayList<>();
        Productos chacarero = new Productos("Chacarero", "(Carne, Tomate, Porotos Verdes, Ají y Mayonesa)", 3500,false);
        Productos barrosLuco = new Productos("Barros Luco", "(Carne, Queso)", 3800,false);
        Productos italiano = new Productos("Italiano", "(Carne, Tomate, Palta y Mayonesa)", 3500,false);
        Productos dinamico = new Productos("Dinámico", "(Carne, Tomate, Palta, Salsa Americana y Mayonesa)", 4000, false);

        listaDeProductos.add(chacarero);
        listaDeProductos.add(barrosLuco);
        listaDeProductos.add(italiano);
        listaDeProductos.add(dinamico);

        return listaDeProductos;
    }



}
