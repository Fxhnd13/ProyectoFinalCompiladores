/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos;

import java.util.List;

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
                        if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                            valor = ((Boolean)this.izq.evaluar(variables)) && ((Boolean)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "OR":{
                    this.tipoRetorno = "Boolean";
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                            valor = ((Boolean)this.izq.evaluar(variables)) && ((Boolean)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "==":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = ((String)this.izq.evaluar(variables)).equals((String)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) == ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = ((Boolean)this.izq.evaluar(variables)) == ((Boolean)this.der.evaluar(variables));
                        }   
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "<>":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = !((String)this.izq.evaluar(variables)).equals((String)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) != ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = ((Boolean)this.izq.evaluar(variables)) != ((Boolean)this.der.evaluar(variables));
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "<=":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = ((String)this.izq.evaluar(variables)).length() <= ((String)this.der.evaluar(variables)).length();
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) <= ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case ">=":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = ((String)this.izq.evaluar(variables)).length() >= ((String)this.der.evaluar(variables)).length();
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) >= ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case ">":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = ((String)this.izq.evaluar(variables)).length() > ((String)this.der.evaluar(variables)).length();
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) > ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "<":{
                    this.tipoRetorno = "Boolean";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("String") && this.der.getTipoRetorno().equals("String")){
                            valor = ((String)this.izq.evaluar(variables)).length() < ((String)this.der.evaluar(variables)).length();
                        }
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) < ((Integer)this.der.evaluar(variables));
                        }
                        if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "+":{
                    if(this.izq.getTipoRetorno().equals("String") || this.der.getTipoRetorno().equals("String")){
                        this.tipoRetorno = "String";
                        if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                            valor = ((String)this.izq.evaluar(variables)) + ((String)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Entero";
                        if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                            valor = ((Integer)this.izq.evaluar(variables)) + ((Integer)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }
                    if(this.izq.getTipoRetorno().equals("Boolean") && this.der.getTipoRetorno().equals("Boolean")){
                        valor = null;
                    }
                    break;
                }
                case "-":{
                    this.tipoRetorno = "Entero";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) - ((Integer)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "*":{
                    this.tipoRetorno = "Entero";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) * ((Integer)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "/":{
                    this.tipoRetorno = "Entero";
                    if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                        if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                            valor = ((Integer)this.izq.evaluar(variables)) / ((Integer)this.der.evaluar(variables));
                        }else{
                            valor = null;
                        }
                    }else{
                        valor = null;
                    }
                    break;
                }
                case "..":{
                    if(this.izq.getTipoRetorno().equals("Entero") && this.der.getTipoRetorno().equals("Entero")){
                        this.tipoRetorno = "Rango";
                        if((izq.evaluar(variables)!=null)&&(der.evaluar(variables)!=null)){
                            Rango rango = new Rango();
                            rango.setInicio((Integer) this.getIzq().evaluar(variables));
                            rango.setFin((Integer) this.getDer().evaluar(variables));
                            valor = rango;
                        }else{
                            valor = null;
                        }
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
                            if(variables.getVariable((String)variable.getValor()).getValor() != null){
                                valor = Integer.parseInt(variables.getVariable((String)variable.getValor()).getValor().toString());
                            }else{
                                valor = null;
                            }
                            break;
                        }
                        case "Boolean":{
                            this.tipoRetorno = "Boolean";
                            if(variables.getVariable((String)variable.getValor()).getValor()!= null){
                                valor = Boolean.parseBoolean(variables.getVariable((String)variable.getValor()).getValor().toString());
                            }else{
                                valor = null;
                            }
                            break;
                        }
                        case "String":{
                            this.tipoRetorno = "String";
                            if(variables.getVariable((String)variable.getValor()).getValor()!= null){
                                valor = (String) variables.getVariable((String)variable.getValor()).getValor();
                            }else{
                                valor = null;
                            }
                            break;
                        }
                    }
                    break;
                }
                case "Entero":{
                    this.tipoRetorno = "Entero";
                    valor = Integer.parseInt(variable.getValor().toString());
                    break;
                }
                case "Boolean":{
                    this.tipoRetorno = "Boolean";
                    valor = Boolean.parseBoolean(variable.getValor().toString());
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

    public boolean evaluarVariables(TablaDeSimbolos variables, List<String> listErrores) {
        boolean valor = true;
        if(this.operador != null){
            if(valor){
                boolean izq = this.izq.evaluarVariables(variables, listErrores);
                boolean der = this.der.evaluarVariables(variables, listErrores);
                valor = izq && der;
            }else{
                this.izq.evaluarVariables(variables, listErrores);
                this.der.evaluarVariables(variables, listErrores);
            }
        }else{
            Variable variable = this.valor;
            if(variable.getTipo().equals("Id")){
                if(variables.getVariable((String) variable.getValor()) == null){
                    listErrores.add("No existe la variable "+variable.getValor()+" utilizada en la linea: "+variable.getLinea()+", columna: "+variable.getColumna());
                    valor = false;
                }
            }
        }
        return valor;
    }
}
