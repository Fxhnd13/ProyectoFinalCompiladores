/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Color;

/**
 *
 * @author jose_
 */
public class ColorP{
    
    Color color = null;
    int red = -1, blue=-1, green=-1;
    String hex = null;
    
    public void CargarColorP(){
        if(this.hex == null){
            int r = red / 256;
            int b = blue / 256;
            int g = green / 256;
            this.color = new Color(r, g, b);
        }else{
            this.color = Color.decode(hex);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
    
}
