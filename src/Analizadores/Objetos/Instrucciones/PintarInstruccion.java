/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.NodoPosicion;

/**
 *
 * @author fxhnd
 */
public class PintarInstruccion {
    
    String idColor, idImagen;
    NodoPosicion posX, posY;

    public String getIdColor() {
        return idColor;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public NodoPosicion getPosX() {
        return posX;
    }

    public void setPosX(NodoPosicion posX) {
        this.posX = posX;
    }

    public NodoPosicion getPosY() {
        return posY;
    }

    public void setPosY(NodoPosicion posY) {
        this.posY = posY;
    }
    
}
