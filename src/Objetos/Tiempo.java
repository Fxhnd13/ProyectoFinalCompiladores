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
    
    String idInicio = null, idFin=null;
    List<Imagen> imagenes;

    public Tiempo(){
        this.imagenes = new ArrayList<>();
    }

    public String getIdInicio() {
        return idInicio;
    }

    public void setIdInicio(String idInicio) {
        this.idInicio = idInicio;
    }

    public String getIdFin() {
        return idFin;
    }

    public void setIdFin(String idFin) {
        this.idFin = idFin;
    }
    
    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "\n    Tiempo{" + "\n      idInicio=" + idInicio + ", \n      idFin=" + idFin + ", \n      imagenes=" + imagenes + "\n    }";
    }
    
}
