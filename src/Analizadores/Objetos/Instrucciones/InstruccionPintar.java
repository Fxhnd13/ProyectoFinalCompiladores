/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

/**
 *
 * @author fxhnd
 */
public class InstruccionPintar {
    
    String idColor, idImagen;
    int posX, posY;

    public InstruccionPintar(String idColor, String idImagen, int posX, int posY) {
        this.idColor = idColor;
        this.idImagen = idImagen;
        this.posX = posX;
        this.posY = posY;
    }
    
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
}
