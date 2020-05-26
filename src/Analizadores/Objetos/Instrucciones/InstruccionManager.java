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
    
    public void ejecutarInstrucciones(String lienzo, List<Instruccion> instrucciones, TablaDeSimbolos variables, List<InstruccionPintar> pinturas, List<String> errores){
        for (Instruccion instruccion : instrucciones) {
            instruccion.setLienzo(lienzo);
            switch(instruccion.getTipo()){
                case "IF":{
                    SiInstruccion temporal = (SiInstruccion) instruccion.getInstruccion();
                    if(temporal.getCondiciones().evaluar(variables) != null){
                        if((Boolean) temporal.getCondiciones().evaluar(variables)){
                            ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstruccionesSi(), variables, pinturas, errores);
                        }else{
                            if(temporal.getInstruccionesSiNo() != null){
                                ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstruccionesSiNo(), variables, pinturas, errores);
                            }
                        }
                    }else{
                        errores.add("Error durante la ejecucion con la expresion condicional usada en la instruccion IF de la linea: "+instruccion.getLinea()+", columna: "+instruccion.getColumna());
                    }
                    break;
                }
                case "WHILE":{
                    MientrasInstruccion temporal = (MientrasInstruccion) instruccion.getInstruccion();
                    if(temporal.getCondiciones().evaluar(variables) != null){
                        while((Boolean)temporal.getCondiciones().evaluar(variables)){
                            ejecutarInstrucciones(instruccion.getLienzo(), temporal.getInstrucciones(), variables, pinturas, errores);
                        }
                    }else{
                        errores.add("Error durante la ejecucion con la expresion condicional usada en la instruccion while en la linea: "+instruccion.getLinea()+", columna: "+instruccion.getColumna());
                    }
                    break;
                }
                case "PINTAR":{
                    PintarInstruccion temporal = (PintarInstruccion) instruccion.getInstruccion();
                    if(temporal.getPosY().evaluar(variables) != null && temporal.getPosX().evaluar(variables) != null){
                        if(temporal.getPosX().getTipoRetorno().equals("Entero") && temporal.getPosY().getTipoRetorno().equals("Entero")){
                                InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables), 
                                        (Integer) temporal.getPosX().evaluar(variables), 
                                        (Integer) temporal.getPosY().evaluar(variables));
                                pintar.setPosicion(instruccion.getLinea(), instruccion.getColumna());
                                pinturas.add(pintar);
                        }else{
                            if(temporal.getPosX().getTipoRetorno().equals("Rango") && temporal.getPosY().getTipoRetorno().equals("Entero")){ // si hay rango en x pero expresion en y
                                int indiceFinalX = ((Rango)temporal.getPosX().evaluar(variables)).getFin();
                                int indiceEnY = (Integer) temporal.getPosY().evaluar(variables);
                                for(int indiceInicialX = ((Rango)temporal.getPosX().evaluar(variables)).getInicio(); indiceInicialX<=indiceFinalX; indiceInicialX++){
                                    InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables),
                                        indiceInicialX, indiceEnY);
                                    pintar.setPosicion(instruccion.getLinea(), instruccion.getColumna());
                                    pinturas.add(pintar);
                                }
                            }
                            if(temporal.getPosX().getTipoRetorno().equals("Entero") && temporal.getPosY().getTipoRetorno().equals("Rango")){ // si hay rango en x pero expresion en y
                                int indiceEnX = (Integer) temporal.getPosX().evaluar(variables);
                                int indiceFinalY = ((Rango)temporal.getPosY().evaluar(variables)).getFin();
                                for(int indiceInicialY = ((Rango)temporal.getPosY().evaluar(variables)).getInicio(); indiceInicialY<=indiceFinalY; indiceInicialY++){
                                    InstruccionPintar pintar = new InstruccionPintar(lienzo, (String) temporal.getIdColor().evaluar(variables), (String) temporal.getIdImagen().evaluar(variables),
                                        indiceEnX, indiceInicialY);
                                    pintar.setPosicion(instruccion.getLinea(), instruccion.getColumna());
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
                                        pintar.setPosicion(instruccion.getLinea(), instruccion.getColumna());
                                        pinturas.add(pintar);
                                    }
                                }
                            }
                        }
                    }else{
                        if(temporal.getPosX().evaluar(variables) == null){
                            errores.add("Error en la expresion para la posicion en x, de la instruccion PINTAR en la linea: "+instruccion.getLinea()+", columna: "+instruccion.getColumna());
                        }else{
                            errores.add("Error en la expresion para la posicion en y, de la instruccion PINTAR en la linea: "+instruccion.getLinea()+", columna: "+instruccion.getColumna());
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

    public void ejecutarPintura(InstruccionPintar pintura, Lienzo lienzo, List<String> errores) {
        if(lienzo.existeColor(pintura.getIdColor()) && lienzo.existeImagen(pintura.getIdImagen())){
            ColorP color = lienzo.getColor(pintura.getIdColor());
            color.CargarColorP();
            if(lienzo.existePosicion(pintura.getPosX(), pintura.getPosY())){
                lienzo.getTiempos().getImagen(pintura.getIdImagen()).pintarPos(color, pintura.getPosX(), pintura.getPosY());
            }else{
                errores.add("No existe la posicion ("+pintura.getPosX()+","+pintura.getPosY()+") en el lienzo "+pintura.getIdLienzo()+"definido");
            }
        }else{
            if(!lienzo.existeColor(pintura.getIdColor())) errores.add("No existe el color utilizado al ejecutar la instruccion pintar declarada en la linea: "+pintura.getLinea()+", columna: "+pintura.getColumna());
            if(!lienzo.existeImagen(pintura.getIdImagen())) errores.add("No existe la imagen utilizada al ejecutar la instruccion pintar declarada en la linea: "+pintura.getLinea()+", columna: "+pintura.getColumna());
        }
    }
    
}
