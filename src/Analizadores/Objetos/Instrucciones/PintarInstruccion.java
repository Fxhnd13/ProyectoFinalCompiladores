/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.Nodo;

/**
 *
 * @author fxhnd
 */
public class PintarInstruccion {
    
    
    Nodo posX, posY, idColor, idImagen;

    public Nodo getIdColor() {
        return idColor;
    }

    public void setIdColor(Nodo idColor) {
        this.idColor = idColor;
    }

    public Nodo getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Nodo idImagen) {
        this.idImagen = idImagen;
    }
    
    public Nodo getPosX() {
        return posX;
    }

    public void setPosX(Nodo posX) {
        this.posX = posX;
    }

    public Nodo getPosY() {
        return posY;
    }

    public void setPosY(Nodo posY) {
        this.posY = posY;
    }
    
}
