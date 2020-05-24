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
public class Instruccion {
    
    String lienzo;
    String tipo = null;
    Object instruccion = null;
    int linea, columna;

    public Instruccion(String tipo, Object instruccion) {
        this.tipo = tipo;
        this.instruccion = instruccion;
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

    public String getLienzo() {
        return lienzo;
    }

    public void setLienzo(String lienzo) {
        this.lienzo = lienzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Object instruccion) {
        this.instruccion = instruccion;
    }
    
}
