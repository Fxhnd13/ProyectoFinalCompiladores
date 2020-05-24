/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import UI.Cell;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author jose_
 */
public class Imagen {
    
    String id = null;
    int duracion = -1, lineaT, columnaT; 
    JPanel panel = null;

    public void pintarPos(ColorP color, int x, int y){
        for (Component component : panel.getComponents()) {
            Cell cell = (Cell) component;
            if(cell.getDx()==x && cell.getDy()==y){
                cell.setColor(color);
            }
        }
    }
    
    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getLineaT() {
        return lineaT;
    }

    public void setLineaT(int lineaT) {
        this.lineaT = lineaT;
    }

    public int getColumnaT() {
        return columnaT;
    }

    public void setColumnaT(int columnaT) {
        this.columnaT = columnaT;
    }

    @Override
    public String toString() {
        return "\n        Imagen{" + "\n          id=" + id + ", \n          duracion=" + duracion + "\n      }";
    }
    
    public String instrucciones(ColorP fondo){
        String cadena = "";
        for (Component component : this.panel.getComponents()) {
            Cell cell = (Cell) component;
            if(cell.getColor()!= fondo){
                cadena+="    PINTAR(\""+cell.getColor().getId()+"\","+this.id+","+cell.getDx()+","+cell.getDy()+");\n";
            }
        }
        return cadena;
    }
    
}
