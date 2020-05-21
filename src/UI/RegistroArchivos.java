/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fxhnd
 */
public class RegistroArchivos {
    
    public static InputTab cargarArchivo(){
        InputTab tab = null;
        String contenido = "";
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setFileFilter(new FileNameExtensionFilter("Archivos Lienzo","lnz"));
        filechooser.setFileFilter(new FileNameExtensionFilter("Archivos Colores","clrs"));
        filechooser.setFileFilter(new FileNameExtensionFilter("Archivos Tiempos","tmp"));
        filechooser.setFileFilter(new FileNameExtensionFilter("Archivos Pintar","pnt"));
        int resultado = filechooser.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File archivo = filechooser.getSelectedFile();
            if(archivo == null || archivo.getName().equals("")){
                JOptionPane.showMessageDialog(null, "No seleccionó una archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    String cadena;
                    FileReader f = new FileReader(archivo);
                    BufferedReader b = new BufferedReader(f);
                    while((cadena = b.readLine())!=null) {
                        contenido += cadena+"\n";
                    }
                    int indice =  archivo.getName().lastIndexOf(".");
                    tab = new InputTab(archivo.getName().substring(0, indice), archivo);
                    tab.getTextArea().setText(contenido);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegistroArchivos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RegistroArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tab;
    }

    static void guardarArchivo(InputTab tab) {
        File archivo = null;
        if(tab.getOrigin() == null){
            JFileChooser filechooser = new JFileChooser();
            filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int resultado = filechooser.showOpenDialog(null);
            if(resultado == JFileChooser.APPROVE_OPTION){
                File temp = filechooser.getSelectedFile();
                if(temp != null){
                    String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre del archivo: ");
                    archivo = new File(temp+"/"+nombre+"."+tab.getExtension());
                }
                tab.setOrigin(archivo);
            }
        }
        if(tab.getOrigin() != null){
            FileWriter fichero = null;
            PrintWriter pw = null;
            try
            {
                fichero = new FileWriter(tab.getOrigin());
                pw = new PrintWriter(fichero);

                pw.print(tab.getText());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               // Nuevamente aprovechamos el finally para 
               // asegurarnos que se cierra el fichero.
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
        }
        
    }
    
}
