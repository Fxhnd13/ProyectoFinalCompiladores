/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.NodoOperacion;

/**
 *
 * @author fxhnd
 */
public class AsignacionInstruccion {
    
    String id;
    NodoOperacion derecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodoOperacion getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoOperacion derecha) {
        this.derecha = derecha;
    }
    
}
