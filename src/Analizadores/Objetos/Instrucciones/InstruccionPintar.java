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
    
    String idLienzo;
    String idColor, idImagen;
    int posX, posY, linea, columna;

    public InstruccionPintar(String idLienzo, String idColor, String idImagen, int posX, int posY) {
        this.idLienzo = idLienzo;
        this.idColor = idColor;
        this.idImagen = idImagen;
        this.posX = posX;
        this.posY = posY;
    }

    public String getIdLienzo() {
        return idLienzo;
    }

    public void setIdLienzo(String idLienzo) {
        this.idLienzo = idLienzo;
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

    @Override
    public String toString() {
        return "InstruccionPintar{" + "idLienzo=" + idLienzo + ", idColor=" + idColor + ", idImagen=" + idImagen + ", posX=" + posX + ", posY=" + posY + '}';
    }

    void setPosicion(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
