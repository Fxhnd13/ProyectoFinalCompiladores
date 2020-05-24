/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos;

import java.util.HashMap;

/**
 *
 * @author fxhnd
 */
public class TablaDeSimbolos {
    
    HashMap<String, Variable> variables = new HashMap<String, Variable>();
    
    public boolean verificarDisponibilidad(String nuevo){
        return variables.containsKey(nuevo);
    }
    
    public boolean addVariable(Variable variable){
        if(!verificarDisponibilidad(variable.getId())){
            variables.put(variable.getId(), variable);
            return true;
        }else{
            return false;
        }
    }
    
    public Variable getVariable(String id){
        if(verificarDisponibilidad(id)){
            return variables.get(id);
        }else{
            return null;
        }
    }
}
