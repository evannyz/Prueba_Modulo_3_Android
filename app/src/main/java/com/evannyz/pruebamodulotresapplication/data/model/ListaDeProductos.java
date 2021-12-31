package com.evannyz.pruebamodulotresapplication.data.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeProductos {

   public static List<Productos> listaDeProductos() {
        String urlChacarero,urlBarrosLuco,urlItaliano,urlDinamico;
        urlChacarero= "https://www.gourmet.cl/wp-content/uploads/2019/04/Chacarero-edit.jpg";
        urlBarrosLuco= "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrWPSiIyr0UXn5UGOjtqS3kPIZ08MozpRbsvCemm5in0oKQJE1AIqHEUCueiZIt08hGPU&usqp=CAU";
        urlItaliano = "https://tiendaenlinea.cl/grupo6/wp-content/uploads/2015/11/churrasco-it.jpg";
        urlDinamico= "https://images.jumpseller.com/store/zenwich/8500809/IMG_6261.jpg?1619287621";
        List<Productos> listaDeProductos = new ArrayList<>();
        Productos chacarero = new Productos(urlChacarero,"Chacarero", "(Carne, Tomate, Porotos Verdes, Ají y Mayonesa)", 3500,false);
        Productos barrosLuco = new Productos(urlBarrosLuco,"Barros Luco", "(Carne, Queso)", 3800,false);
        Productos italiano = new Productos(urlItaliano,"Italiano", "(Carne, Tomate, Palta y Mayonesa)", 3500,false);
        Productos dinamico = new Productos(urlDinamico,"Dinámico", "(Carne, Tomate, Palta, Salsa Americana y Mayonesa)", 4000, false);

        listaDeProductos.add(chacarero);
        listaDeProductos.add(barrosLuco);
        listaDeProductos.add(italiano);
        listaDeProductos.add(dinamico);

        return listaDeProductos;
    }



}
