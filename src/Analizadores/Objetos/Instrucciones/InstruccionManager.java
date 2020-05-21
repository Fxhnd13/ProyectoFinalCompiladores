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
    
    public static void ejecutarInstrucciones(Lienzo lienzo, List<Instruccion> instrucciones, TablaDeSimbolos variables){
        for (Instruccion instruccion : instrucciones) {
            switch(instruccion.getTipo()){
                case "if":{
                    SiInstruccion temporal = (SiInstruccion) instruccion.getInstruccion();
                    if()
                    break;
                }
                case "while":{
                    MientrasInstruccion temporal = (MientrasInstruccion) instruccion.getInstruccion();
                    break;
                }
                case "PINTAR":{
                    PintarInstruccion temporal = (PintarInstruccion) instruccion.getInstruccion();
                    break;
                }
            }
        }
    }
}
