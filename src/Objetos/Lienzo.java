/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Analizadores.Objetos.Instrucciones.Instruccion;
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
    Tiempo tiempos = null;
    List<Instruccion> instrucciones;
    
    public boolean existeColor(String color){
        boolean valor = false;
        for (ColorP colorT : colores) {
            if(colorT.getId().equals(color)) valor = true;
        }
        return valor;
    }
    
    public boolean existeImagen(String imagen){
        boolean valor = false;
        for (Imagen imagenT : tiempos.getImagenes()) {
            if(imagenT.getId().equals(imagen)) valor = true;
        }
        return valor;
    }
    
    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(List<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public Lienzo(){
        instrucciones = new ArrayList<>();
        colores = new ArrayList<>();
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

    public void addColores(List<ColorP> colores, List<String> errores){
        for (ColorP color : colores) {
            if(!this.existeColor(color.getId())){
                this.colores.add(color);
            }else{
                errores.add("Ya existe el color "+color.getId()+"declarado en la linea:"+color.getLinea()+", columna"+color.getColumna());
            }
        }
    }
    
    public void setColores(List<ColorP> colores) {
        this.colores = colores;
    }

    public Tiempo getTiempos() {
        return tiempos;
    }

    public void setTiempos(Tiempo tiempos) {
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

    @Override
    public String toString() {
        return "Lienzo{" + "\n  id=" + id + ", \n  idSalida=" + idSalida + ", \n  extension=" + extension + ", \n  fondo=" + fondo + ", \n  cuadros=" + cuadros + ", \n  dX=" + dX + ", \n  dY=" + dY + ", \n  colores=" + colores + ", \n  tiempos=" + tiempos + "\n}";
    }
    
    public String instrucciones(){
        String cadena = "";
        for (Imagen imagen : this.tiempos.getImagenes()) {
            cadena+= imagen.instrucciones(this.fondo);
        }
        return cadena;
    }

    public String getEstructuraLienzo() {
        return id+":{ \n  nombre:\"" + idSalida + "\", \n  tipo:\"" + extension + "\", \n  Fondo:{" + fondo.getEstructura() +"\n  },\n  tamaño:{\n    cuadro:" + cuadros + ", \n    dimension_x:" + dX + ", \n    dimension_y:" + dY + "\n  }\n}";
    }

    public String getEstructuraColores() {
        String cadena = "";
        for (int i = 0; i < colores.size(); i++) {
            cadena+="  "+colores.get(i).getId()+":{\n    "+colores.get(i).getValue()+"\n  }\n";
            if((i+1)<colores.size()) cadena+=",\n";
        }
        return id+":{\n"+cadena+"}";
    }

    public String getEstructuraTiempos() {
        return id+":{"+tiempos.getEstructura()+"\n}";
    }

    public ColorP getColor(String idColor) {
        ColorP valor = null;
        for (ColorP color : colores) {
            if(idColor.equals(color.getId())) valor = color;
        }
        return valor;
    }

    public boolean existePosicion(int posX, int posY) {
        if(dX >= posX && dY >= posY){
            return true;
        }else{
            return false;
        }
    }
}
