/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose_
 */
public class Tiempo {
    
    String idInicio = null, idFin=null;
    List<Imagen> imagenes;
    int lineaT, columanT;

    public Tiempo(){
        this.imagenes = new ArrayList<Imagen>();
    }

    public String getIdInicio() {
        return idInicio;
    }

    public void setIdInicio(String idInicio) {
        this.idInicio = idInicio;
    }

    public String getIdFin() {
        return idFin;
    }

    public void setIdFin(String idFin) {
        this.idFin = idFin;
    }
    
    public Imagen getImagen(String id){
        Imagen imagen = null;
        for (Imagen imagent : imagenes) {
            if(id.equals(imagent.getId())) imagen = imagent;
        }
        return imagen;
    }
    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public int getLineaT() {
        return lineaT;
    }

    public void setLineaT(int lineaT) {
        this.lineaT = lineaT;
    }

    public int getColumnaT() {
        return columanT;
    }

    public void setColumnaT(int columanT) {
        this.columanT = columanT;
    }

    @Override
    public String toString() {
        return "\n    Tiempo{" + "\n      idInicio=" + idInicio + ", \n      idFin=" + idFin + ", \n      imagenes=" + imagenes + "\n    }";
    }

    public String getEstructura() {
        String cadena = "";
        for (int i = 0; i < imagenes.size(); i++) {
            cadena+="\n    {\n      id:\""+imagenes.get(i).getId()+"\",\n      duracion:"+imagenes.get(i).getDuracion()+"\n    }";
            if((i+1) < imagenes.size()) cadena+=",\n";
        }
        return "\n  inicio:\""+idInicio+"\",\n  fin:\""+idFin+"\",\n  imagenes:["+cadena+"\n  ]";
    }

    public boolean existe(String id) {
        boolean valor = false;
        for (Imagen imagen : imagenes) {
            if(imagen.getId().equals(id)) valor = true;
        }
        return valor;
    }

    public int getIndice(String id) {
        int indice = 0;
        for (int i = 0; i < imagenes.size(); i++) {
            if(imagenes.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        return indice;
    }
    
}
