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
public class NodoOperacion {
    
    String operador = null;
    NodoOperacion izq;
    NodoOperacion der;
    Object valor;
    
    public NodoOperacion(String operador, NodoOperacion izq, NodoOperacion der){
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }
    
    public NodoOperacion(Object valor){
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    public int evaluar(TablaDeSimbolos variables){
        if(this.operador != null){
            switch(this.operador){
                case "*": return (this.izq.evaluar(variables) * this.der.evaluar(variables));
                case "/": return (this.izq.evaluar(variables) / this.der.evaluar(variables));
                case "+": return (this.izq.evaluar(variables) + this.der.evaluar(variables));
                case "-": return (this.izq.evaluar(variables) - this.der.evaluar(variables));
                default: return 0;
            }
        }else{
            if(variables.getVariable(this.valor.toString())!=null){
                return (Integer) variables.getVariable(this.valor.toString()).getValor();
            }else{
                return 0;
            }
        }
    }
    
}
