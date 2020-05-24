package UI;


import Analizadores.Objetos.Instrucciones.InstruccionManager;
import Analizadores.Objetos.Instrucciones.InstruccionPintar;
import Analizadores.Objetos.TablaDeSimbolos;
import Objetos.Lienzo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fxhnd
 */
public class Pintor extends javax.swing.JFrame {

    private List<Lienzo> lienzos = new ArrayList<Lienzo>();
    private File fileLienzo, fileColores, fileTiempos, filePintar;
    
    /**
     * Creates new form Pintor
     */
    public Pintor() {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
    }
    
    public void setFiles(File lienzo, File colores, File tiempos, File pintar){
        this.fileLienzo = lienzo;
        this.fileColores = colores;
        this.fileTiempos = tiempos;
        this.filePintar = pintar;
    }
    
    public void setLienzos(List<Lienzo> lienzos, TablaDeSimbolos variables){
        this.lienzos = lienzos;
        for (Lienzo lienzo : lienzos) {
            addLienzoTab(lienzo, variables);
        }
    }

    private void addLienzoTab(Lienzo lienzo, TablaDeSimbolos variables){
        PanelLienzo panelLienzo = new PanelLienzo(lienzo, variables);
        this.LienzosPane.addTab("Lienzo: "+lienzo.getId(), panelLienzo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoTexto = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoLienzo = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextoColores = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextoTiempos = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextoPintar = new javax.swing.JTextArea();
        LienzosPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        DialogoTexto.setSize(new java.awt.Dimension(750, 500));

        TextoLienzo.setColumns(20);
        TextoLienzo.setRows(5);
        jScrollPane1.setViewportView(TextoLienzo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estructura Lienzo", jPanel1);

        TextoColores.setColumns(20);
        TextoColores.setRows(5);
        jScrollPane2.setViewportView(TextoColores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estructura Colores", jPanel2);

        TextoTiempos.setColumns(20);
        TextoTiempos.setRows(5);
        jScrollPane3.setViewportView(TextoTiempos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estructura Tiempos", jPanel3);

        TextoPintar.setColumns(20);
        TextoPintar.setRows(5);
        jScrollPane4.setViewportView(TextoPintar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estructura Pintar", jPanel4);

        javax.swing.GroupLayout DialogoTextoLayout = new javax.swing.GroupLayout(DialogoTexto.getContentPane());
        DialogoTexto.getContentPane().setLayout(DialogoTextoLayout);
        DialogoTextoLayout.setHorizontalGroup(
            DialogoTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        DialogoTextoLayout.setVerticalGroup(
            DialogoTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("Opciones");

        jMenuItem1.setText("Ver estructura actual en texto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Guardar Cambios");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzosPane, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzosPane, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String cadenaLienzo = "{\nLIENZOS:{\n";
        for (Lienzo lienzo : lienzos) {
            cadenaLienzo += lienzo.getEstructuraLienzo();
        }
        cadenaLienzo+="\n}\n}";
        String cadenaColores = "{\nCOLORES:{\n";
        for (Lienzo lienzo : lienzos) {
            cadenaColores+= lienzo.getEstructuraColores();
        }
        cadenaColores += "\n}\n}";
        String cadenaTiempos = "{\nTIEMPOS:{\n";
        for (Lienzo lienzo : lienzos) {
            cadenaTiempos+= lienzo.getEstructuraTiempos();
        }
        cadenaTiempos+="\n}\n}";
        String cadenaPintar = "";
        for (Lienzo lienzo : lienzos) {
            if(!lienzo.instrucciones().isEmpty()) cadenaPintar+= "INSTRUCCIONES("+lienzo.getId()+"){\n"+lienzo.instrucciones()+"}";
            cadenaPintar+="\n";
        }
        RegistroArchivos.guardarCambiosEditor(this.fileLienzo, cadenaLienzo);
        RegistroArchivos.guardarCambiosEditor(this.fileColores, cadenaColores);
        RegistroArchivos.guardarCambiosEditor(this.fileTiempos, cadenaTiempos);
        RegistroArchivos.guardarCambiosEditor(this.filePintar, cadenaPintar);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String cadenaLienzo = "";
        for (Lienzo lienzo : lienzos) {
            cadenaLienzo += lienzo.getEstructuraLienzo();
        }
        String cadenaColores = "";
        for (Lienzo lienzo : lienzos) {
            cadenaColores+= lienzo.getEstructuraColores();
        }
        String cadenaTiempos = "";
        for (Lienzo lienzo : lienzos) {
            cadenaTiempos+= lienzo.getEstructuraTiempos();
        }
        String cadenaPintar = "";
        for (Lienzo lienzo : lienzos) {
            if(!lienzo.instrucciones().isEmpty()) cadenaPintar+= "INSTRUCCIONES("+lienzo.getId()+"){\n"+lienzo.instrucciones()+"}";
            cadenaPintar+="\n";
        }
        this.TextoLienzo.setText(cadenaLienzo);
        this.TextoColores.setText(cadenaColores);
        this.TextoTiempos.setText(cadenaTiempos);
        this.TextoPintar.setText(cadenaPintar);
        this.DialogoTexto.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pintor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pintor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pintor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pintor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pintor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogoTexto;
    private javax.swing.JTabbedPane LienzosPane;
    private javax.swing.JTextArea TextoColores;
    private javax.swing.JTextArea TextoLienzo;
    private javax.swing.JTextArea TextoPintar;
    private javax.swing.JTextArea TextoTiempos;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
