package com.evannyz.pruebamodulotresapplication.logic;

public class ValidadorSegunEstado {

    public Integer compruebaEstadoDevuelveTotal(boolean estado, int precio,int total) {
        if (!estado){
            total = total+precio;
        }else{
            total = total-precio;
        }
        return total;
    }
}
