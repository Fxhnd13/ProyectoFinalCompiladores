/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.TablaDeSimbolos;
import Objetos.Lienzo;
import java.util.List;

/**
 *
 * @author fxhnd
 */
public class InstruccionManager {
    
    public void ejecutarInstrucciones(Lienzo lienzo, List<Instruccion> instrucciones, TablaDeSimbolos variables, List<InstruccionPintar> pinturas){
        for (Instruccion instruccion : instrucciones) {
            switch(instruccion.getTipo()){
                case "if":{
                    SiInstruccion temporal = (SiInstruccion) instruccion.getInstruccion();
                    if(temporal.getCondiciones().evaluar(variables)){
                        ejecutarInstrucciones(lienzo, temporal.getInstruccionesSi(), variables, pinturas);
                    }else{
                        if(temporal.getInstruccionesSiNo() != null){
                            ejecutarInstrucciones(lienzo, temporal.getInstruccionesSiNo(), variables, pinturas);
                        }
                    }
                    break;
                }
                case "while":{
                    MientrasInstruccion temporal = (MientrasInstruccion) instruccion.getInstruccion();
                    while(temporal.getCondiciones().evaluar(variables)){
                        ejecutarInstrucciones(lienzo, temporal.getInstrucciones(), variables, pinturas);
                    }
                    break;
                }
                case "PINTAR":{
                    PintarInstruccion temporal = (PintarInstruccion) instruccion.getInstruccion();
                    if(temporal.getPosX().getMedio() != null && temporal.getPosY().getMedio() != null){ //si ambos son solamente expresiones
                        InstruccionPintar pintar = new InstruccionPintar(temporal.getIdColor(), temporal.getIdImagen(), 
                                temporal.getPosX().getMedio().evaluar(variables), 
                                temporal.getPosY().getMedio().evaluar(variables));
                        pinturas.add(pintar);
                    }else{
                        if(temporal.getPosX().getMedio() == null && temporal.getPosY().getMedio() != null){ // si hay rango en x pero expresion en y
                            int indiceFinalX = temporal.getPosX().getDer().evaluar(variables);
                            int indiceEnY = temporal.getPosY().getMedio().evaluar(variables);
                            for(int indiceInicialX = temporal.getPosX().getIzq().evaluar(variables); indiceInicialX<=indiceFinalX; indiceInicialX++){
                                InstruccionPintar pintar = new InstruccionPintar(temporal.getIdColor(), temporal.getIdImagen(),
                                    indiceInicialX, indiceEnY);
                                pinturas.add(pintar);
                            }
                        }
                        if(temporal.getPosY().getMedio() == null && temporal.getPosX().getMedio() != null){ // si hay rango en y pero expresion en x
                            int indiceFinalY = temporal.getPosY().getDer().evaluar(variables);
                            int indiceEnX = temporal.getPosX().getMedio().evaluar(variables);
                            for(int indiceInicialY = temporal.getPosX().getIzq().evaluar(variables); indiceInicialY<=indiceFinalY; indiceInicialY++){
                                InstruccionPintar pintar = new InstruccionPintar(temporal.getIdColor(), temporal.getIdImagen(),
                                    indiceEnX, indiceInicialY);
                                pinturas.add(pintar);
                            }
                        }
                        if(temporal.getPosX().getMedio() == null && temporal.getPosY().getMedio() == null){ // si hay rango en x y
                            int indiceFinalX = temporal.getPosX().getDer().evaluar(variables);
                            int indiceFinalY = temporal.getPosY().getDer().evaluar(variables);
                            for(int indiceInicialX = temporal.getPosX().getIzq().evaluar(variables); indiceInicialX <= indiceFinalX; indiceInicialX++){
                                for(int indiceInicialY = temporal.getPosY().getIzq().evaluar(variables); indiceInicialY <= indiceFinalY; indiceInicialY++){
                                    InstruccionPintar pintar = new InstruccionPintar(temporal.getIdColor(), temporal.getIdImagen(),
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
}
