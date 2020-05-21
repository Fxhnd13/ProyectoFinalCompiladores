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

    public NodoCondicion getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(NodoCondicion condiciones) {
        this.condiciones = condiciones;
    }

    public List<Instruccion> getInstruccionesSi() {
        return instruccionesSi;
    }

    public void setInstruccionesSi(List<Instruccion> instruccionesSi) {
        this.instruccionesSi = instruccionesSi;
    }

    public List<Instruccion> getInstruccionesSiNo() {
        return instruccionesSiNo;
    }

    public void setInstruccionesSiNo(List<Instruccion> instruccionesSiNo) {
        this.instruccionesSiNo = instruccionesSiNo;
    }
    
}
