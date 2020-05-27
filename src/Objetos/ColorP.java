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
    String hex = null, id = null;
    int linea, columna;

    public ColorP(){}
    
    public ColorP(Color color, String id) {
        this.red = color.getRed();
        this.blue = color.getBlue();
        this.green = color.getGreen();
        this.color = color;
        this.id = id;
    }
    
    public void CargarColorP(){
        if(this.hex == null){
            int r = red;
            int b = blue;
            int g = green;
            this.color = new Color(r, g, b);
        }else{
            this.color = Color.decode(hex);
        }
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String getValue(){
        String cadena =  "";
        if(hex != null){
            cadena = "        HEX:"+hex;
        }else{
            cadena = "    Red:"+red+",\n        Blue:"+blue+",\n        Green:"+green;
        }
        return cadena;
    }

    @Override
    public String toString() {
        return "\n    ColorP{" + "\n      color=" + color + ", \n      red=" + red + ", \n      blue=" + blue + ", \n      green=" + green + ", \n      hex=" + hex + ", \n      id=" + id + "\n    }";
    }

    public String getEstructura() {
        return "\n    "+getValue();
    }
    
}
