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
public class Nodo {
    
    String tipoRetorno, operador;
    Nodo izq, der;
    Variable valor;

    public Nodo(String tipoRetorno, String operador, Nodo izq, Nodo der){
        this.tipoRetorno = tipoRetorno;
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }
    
    public Nodo(String tipoRetorno, Variable variable){
        this.tipoRetorno = tipoRetorno;
        this.valor = variable;
    }
    
    public Nodo(Variable variable, TablaDeSimbolos variables){
        this.valor = variable;
        this.evaluar(variables);
    }
    
    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Variable valor) {
        this.valor = valor;
    }
    
    public Object evaluar(TablaDeSimbolos variables){
        Object valor = null;
        if(this.operador != null){
            switch(this.operador){
                case "AND":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        valor = ((boolean)this.izq.evaluar(variables)) && ((boolean)this.der.evaluar(variables));
                    }else{
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "OR":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        valor = ((boolean)this.izq.evaluar(variables)) && ((boolean)this.der.evaluar(variables));
                    }else{
                        //podemos agregar une error semantico
                    }
                    break;
                }
                case "==":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = ((String)this.izq.evaluar(variables)).equals((String)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) == ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        valor = ((boolean)this.izq.evaluar(variables)) == ((boolean)this.der.evaluar(variables));
                    }
                    break;
                }
                case "<>":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = !((String)this.izq.evaluar(variables)).equals((String)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) != ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        valor = ((boolean)this.izq.evaluar(variables)) != ((boolean)this.der.evaluar(variables));
                    }
                    break;
                }
                case "<=":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = ((String)this.izq.evaluar(variables)).length() <= ((String)this.der.evaluar(variables)).length();
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) <= ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case ">=":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = ((String)this.izq.evaluar(variables)).length() >= ((String)this.der.evaluar(variables)).length();
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) >= ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case ">":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = ((String)this.izq.evaluar(variables)).length() > ((String)this.der.evaluar(variables)).length();
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) > ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "<":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                        valor = ((String)this.izq.evaluar(variables)).length() < ((String)this.der.evaluar(variables)).length();
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        valor = ((Integer)this.izq.evaluar(variables)) < ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "+":{
                    if(this.izq.getTipoRetorno().equals("String") || this.der.getTipoRetorno().equals("String")){
                        this.tipoRetorno = "String";
                        valor = ((String)this.izq.evaluar(variables)) + ((String)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Entero";
                        valor = ((Integer)this.izq.evaluar(variables)) + ((Integer)this.der.evaluar(variables));
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "-":{
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Entero";
                        valor = ((Integer)this.izq.evaluar(variables)) - ((Integer)this.der.evaluar(variables));
                    }else{
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "*":{
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Entero";
                        valor = ((Integer)this.izq.evaluar(variables)) * ((Integer)this.der.evaluar(variables));
                    }else{
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "/":{
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Entero";
                        valor = ((Integer)this.izq.evaluar(variables)) / ((Integer)this.der.evaluar(variables));
                    }else{
                        //podemos agregar un error semantico
                    }
                    break;
                }
                case "..":{
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Rango";
                        Rango rango = new Rango();
                        rango.setInicio((Integer) this.getIzq().evaluar(variables));
                        rango.setFin((Integer) this.getDer().evaluar(variables));
                        valor = rango;
                    }
                }
            }
        }else{
            Variable variable = this.valor;
            switch(variable.getTipo()){
                case "Id":{
                    switch(variables.getVariable((String)variable.getValor()).getTipo()){
                        case "Entero":{
                            this.tipoRetorno = "Entero";
                            valor = (Integer) variables.getVariable((String)variable.getValor()).getValor();
                            break;
                        }
                        case "Boolean":{
                            this.tipoRetorno = "Boolean";
                            valor = (boolean) variables.getVariable((String)variable.getValor()).getValor();
                            break;
                        }
                        case "String":{
                            this.tipoRetorno = "String";
                            valor = (String) variables.getVariable((String)variable.getValor()).getValor();
                            break;
                        }
                    }
                    break;
                }
                case "Entero":{
                    this.tipoRetorno = "Entero";
                    valor = (Integer) variable.getValor();
                    break;
                }
                case "Boolean":{
                    this.tipoRetorno = "Boolean";
                    valor = (boolean) variable.getValor();
                    break;
                }
                case "String":{
                    this.tipoRetorno = "String";
                    valor = (String) variable.getValor();
                    break;
                }
                case "Rango":{
                    this.tipoRetorno = "Rango";
                    valor = (Rango) variable.getValor();
                    break;
                }
            }
        }
        return valor;
    }
}
