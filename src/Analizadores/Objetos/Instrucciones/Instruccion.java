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
    
    String tipo = null;
    Object instruccion = null;

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
