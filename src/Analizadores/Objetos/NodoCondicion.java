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
public class NodoCondicion {
    
    String operador = null;
    NodoCondicion izq;
    NodoCondicion der;
    Object valor;
    
    public NodoCondicion(String operador, NodoCondicion izq, NodoCondicion der){
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }
    
    public NodoCondicion(Object valor){
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public NodoCondicion getIzq() {
        return izq;
    }

    public void setIzq(NodoCondicion izq) {
        this.izq = izq;
    }

    public NodoCondicion getDer() {
        return der;
    }

    public void setDer(NodoCondicion der) {
        this.der = der;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    public boolean evaluar(TablaDeSimbolos variables) {
        if(this.operador != null){
            switch(this.operador){
                case "AND": return (this.izq.evaluar(variables) && this.der.evaluar(variables));
                case "OR": return (this.izq.evaluar(variables) || this.der.evaluar(variables));
                case "==": return (this.izq.getValor() == this.der.getValor());
                case "<=": return ((Integer)this.izq.getValor() <= (Integer)this.der.getValor());
                case ">=": return ((Integer)this.izq.getValor() >= (Integer)this.der.getValor());
                case ">":  return ((Integer)this.izq.getValor() > (Integer)this.der.getValor());
                case "<":  return ((Integer)this.izq.getValor() < (Integer)this.der.getValor());
                case "<>": return ((Integer)this.izq.getValor() != (Integer)this.der.getValor());
                default: return false;
            }
        }else{
            if(variables.getVariable(this.valor.toString())!=null){
                return (boolean) variables.getVariable(this.valor.toString()).getValor();
            }else{
                return false;
            }
        }
    }
    
}
