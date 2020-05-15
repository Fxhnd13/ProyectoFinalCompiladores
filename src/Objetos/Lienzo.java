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
public class Lienzo {
    
    String id=null, idSalida=null, extension=null;
    ColorP fondo = null;
    int cuadros=-1, dX=-1, dY=-1, lineaT, columnaT;
    List<ColorP> colores;
    List<Tiempo> tiempos;

    public Lienzo(){
        colores = new ArrayList<>();
        tiempos = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ColorP getFondo() {
        return fondo;
    }

    public void setFondo(ColorP fondo) {
        this.fondo = fondo;
    }

    public int getCuadros() {
        return cuadros;
    }

    public void setCuadros(int cuadros) {
        this.cuadros = cuadros;
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public List<ColorP> getColores() {
        return colores;
    }

    public void setColores(List<ColorP> colores) {
        this.colores = colores;
    }

    public List<Tiempo> getTiempos() {
        return tiempos;
    }

    public void setTiempos(List<Tiempo> tiempos) {
        this.tiempos = tiempos;
    }

    public int getLineaT() {
        return lineaT;
    }

    public void setLineaT(int lineaT) {
        this.lineaT = lineaT;
    }

    public int getColumnaT() {
        return columnaT;
    }

    public void setColumnaT(int columnaT) {
        this.columnaT = columnaT;
    }
    
}
