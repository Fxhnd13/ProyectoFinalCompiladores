/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.Nodo;
import java.util.List;

/**
 *
 * @author fxhnd
 */
public class MientrasInstruccion {
    
    Nodo condiciones;
    List<Instruccion> instrucciones;

    public Nodo getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(Nodo condiciones) {
        this.condiciones = condiciones;
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(List<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
}
