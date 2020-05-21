/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores.Objetos.Instrucciones;

import Analizadores.Objetos.NodoCondicion;
import java.util.List;

/**
 *
 * @author fxhnd
 */
public class SiInstruccion {
    
    NodoCondicion condiciones;
    List<Instruccion> instruccionesSi, instruccionesSiNo;
}
