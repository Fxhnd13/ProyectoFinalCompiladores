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
    
    String operador = null;
    NodoPosicion izq;
    NodoPosicion der;
    Object valor;
    
    public NodoPosicion(NodoPosicion izq, NodoPosicion der){
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }
    
    public NodoPosicion(Object valor){
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public NodoPosicion getIzq() {
        return izq;
    }

    public void setIzq(NodoPosicion izq) {
        this.izq = izq;
    }

    public NodoPosicion getDer() {
        return der;
    }

    public void setDer(NodoPosicion der) {
        this.der = der;
    }
    
    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
