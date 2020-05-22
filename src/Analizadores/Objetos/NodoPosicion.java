/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos;

/**
 *
 * @author fxhnd
 */
public class NodoPosicion {
    
    NodoOperacion izq, der, medio;
    
    public NodoPosicion(NodoOperacion izq, NodoOperacion der){
        this.izq = izq;
        this.der = der;
    }

    public NodoOperacion getIzq() {
        return izq;
    }

    public void setIzq(NodoOperacion izq) {
        this.izq = izq;
    }

    public NodoOperacion getDer() {
        return der;
    }

    public void setDer(NodoOperacion der) {
        this.der = der;
    }

    public NodoOperacion getMedio() {
        return medio;
    }

    public void setMedio(NodoOperacion medio) {
        this.medio = medio;
    }
    
}
