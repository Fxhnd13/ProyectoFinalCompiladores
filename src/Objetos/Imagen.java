/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author jose_
 */
public class Imagen {
    
    String id = null;
    int duracion = -1; 

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

    @Override
    public String toString() {
        return "\n        Imagen{" + "\n          id=" + id + ", \n          duracion=" + duracion + "\n      }";
    }
    
}
