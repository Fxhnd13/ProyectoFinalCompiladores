/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objetos.ColorP;
import java.awt.Component;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author fxhnd
 */
public class Cell extends JLabel {
    
    private ColorP color;
    private int dx, dy;
    
    public Cell(int x, int y){
        this.dx = x;
        this.dy = y;
    }

    public Cell() {}

    public ColorP getColor() {
        return color;
    }

    public void setColor(ColorP color) {
        this.color = color;
        this.color.CargarColorP();
        this.setBackground(color.getColor());
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
