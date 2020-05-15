/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose_
 */
public class Tiempo {
    
    Imagen idInicio = null, idFin=null;
    List<Imagen> imagenes;

    public Tiempo(){
        this.imagenes = new ArrayList<>();
    }
    
    public Imagen getIdInicio() {
        return idInicio;
    }

    public void setIdInicio(Imagen idInicio) {
        this.idInicio = idInicio;
    }

    public Imagen getIdFin() {
        return idFin;
    }

    public void setIdFin(Imagen idFin) {
        this.idFin = idFin;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    
}
