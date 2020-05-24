/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.Rango;
import Analizadores.Objetos.TablaDeSimbolos;
import Objetos.ColorP;
import Objetos.Lienzo;
import java.util.List;

/**
 *
 * @author fxhnd
 */
public class InstruccionManager {
    
    public void ejecutarInstrucciones(String lienzo, List<Instruccion> instrucciones, TablaDeSimbolos variables, List<InstruccionPintar> pinturas){
        for (Instruccion instruccion : instrucciones) {
            instruccion.setLienzo(lienzo);
            switch(instruccion.getTipo()){
                case "IF":{
                    SiInstruccion temporal = (SiInstruccion) instruccion.getInstruccion();
                    if((boolean) temporal.getCondiciones().evaluar(variables)){
                        ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstruccionesSi(), variables, pinturas);
                    }else{
                        if(temporal.getInstruccionesSiNo() != null){
                            ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstruccionesSiNo(), variables, pinturas);
                        }
                    }
                    break;
                }
                case "WHILE":{
                    MientrasInstruccion temporal = (MientrasInstruccion) instruccion.getInstruccion();
                    while((boolean)temporal.getCondiciones().evaluar(variables)){
                        ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstrucciones(), variables, pinturas);
                    }
                    break;
                }
                case "PINTAR":{
                    PintarInstruccion temporal = (PintarInstruccion) instruccion.getInstruccion();
                    temporal.getPosX().evaluar(variables);
                    temporal.getPosY().evaluar(variables);
                    if(temporal.getPosX().getTipoRetorno().equals("Entero") && temporal.getPosY().getTipoRetorno().equals("Entero")){
                        InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables), 
                                (Integer) temporal.getPosX().evaluar(variables), 
                                (Integer) temporal.getPosY().evaluar(variables));
                        pinturas.add(pintar);
                    }else{
                        if(temporal.getPosX().getTipoRetorno().equals("Rango") && temporal.getPosY().getTipoRetorno().equals("Entero")){ // si hay rango en x pero expresion en y
                            int indiceFinalX = ((Rango)temporal.getPosX().evaluar(variables)).getFin();
                            int indiceEnY = (Integer) temporal.getPosY().evaluar(variables);
                            for(int indiceInicialX = ((Rango)temporal.getPosX().evaluar(variables)).getInicio(); indiceInicialX<=indiceFinalX; indiceInicialX++){
                                InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables),
                                    indiceInicialX, indiceEnY);
                                pinturas.add(pintar);
                            }
                        }
                        if(temporal.getPosX().getTipoRetorno().equals("Entero") && temporal.getPosY().getTipoRetorno().equals("Rango")){ // si hay rango en x pero expresion en y
                            int indiceEnX = (Integer) temporal.getPosX().evaluar(variables);
                            int indiceFinalY = ((Rango)temporal.getPosY().evaluar(variables)).getFin();
                            for(int indiceInicialY = ((Rango)temporal.getPosY().evaluar(variables)).getInicio(); indiceInicialY<=indiceFinalY; indiceInicialY++){
                                InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables),
                                    indiceEnX, indiceInicialY);
                                pinturas.add(pintar);
                            }
                        }
                        if(temporal.getPosX().getTipoRetorno().equals("Rango") && temporal.getPosY().getTipoRetorno().equals("Rango")){ // si hay rango en x y
                            int indiceFinalX = ((Rango)temporal.getPosX().evaluar(variables)).getFin();
                            int indiceFinalY = ((Rango)temporal.getPosY().evaluar(variables)).getFin();
                            for(int indiceInicialX = ((Rango)temporal.getPosX().evaluar(variables)).getInicio(); indiceInicialX <= indiceFinalX; indiceInicialX++){
                                for(int indiceInicialY = ((Rango)temporal.getPosY().evaluar(variables)).getInicio(); indiceInicialY <= indiceFinalY; indiceInicialY++){
                                    InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables),
                                        indiceInicialX, indiceInicialY);
                                    pinturas.add(pintar);
                                }
                            }
                        }
                    }
                    break;
                }
                case "Asignacion":{
                    AsignacionInstruccion temporal = (AsignacionInstruccion) instruccion.getInstruccion();
                    variables.getVariable(temporal.getId()).setValor(temporal.getDerecha().evaluar(variables));
                    break;
                }
            }
        }
    }

    public void ejecutarPintura(InstruccionPintar pintura, Lienzo lienzo) {
        ColorP color = lienzo.getColor(pintura.getIdColor());
        lienzo.getTiempos().getImagen(pintura.getIdImagen()).pintarPos(color, pintura.getPosX(), pintura.getPosY());
    }
    
}
