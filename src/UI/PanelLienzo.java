/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Analizadores.Objetos.Instrucciones.InstruccionManager;
import Analizadores.Objetos.Instrucciones.InstruccionPintar;
import Analizadores.Objetos.TablaDeSimbolos;
import Objetos.ColorP;
import Objetos.GifSequenceWriter;
import Objetos.Imagen;
import Objetos.Lienzo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author fxhnd
 */
public class PanelLienzo extends javax.swing.JPanel {
    
    private Lienzo lienzo;
    private ColorP colorActivo;
    
    public PanelLienzo(Lienzo lienzo, TablaDeSimbolos variables){
            initComponents(); //inicializa todos los componentes del panel
            this.lienzo = lienzo; //capturamos el lienzo correspondiente 
            cargarImagenes(variables);//cargamos las imagenes aqui es donde se deberia dibujar si hay archivo pnt o crear lienzos en blanco si no hay pnt
            cargarColores();//cargamos los colores declarados para la interfaz grafica
    }
    
    public ScrollPane getLienzoPane() {
        return LienzoPane;
    }

    public void setLienzoPane(ScrollPane LienzoPane) {
        this.LienzoPane = LienzoPane;
    }

    public JPanel getToolLienzoPane() {
        return ToolLienzoPane;
    }

    public void setToolLienzoPane(JPanel ToolLienzoPane) {
        this.ToolLienzoPane = ToolLienzoPane;
    }

    public void cargarImagen(Imagen imagen){
        JPanel panel = panel = new JPanel(); //creamos un panel de la imagen
        panel.setSize(this.lienzo.getdX()*this.lienzo.getCuadros(), this.lienzo.getdY()*this.lienzo.getCuadros()); //arreglamos el tamaño que debería tener
        panel.setLayout(new GridLayout(this.lienzo.getdY(), this.lienzo.getdX()));//hacemos el gridlayout (quiza hace falta cambiar)
        for (int i = 0; i < this.lienzo.getdY(); i++) {
            for (int j = 0; j < this.lienzo.getdX(); j++) {
                Cell cell = new Cell(i,j);
                cell.setSize(this.lienzo.getCuadros(), this.lienzo.getCuadros());
                cell.setOpaque(true);
                cell.setBorder(new EtchedBorder());
                this.lienzo.getFondo().CargarColorP();
                cell.setColor(this.lienzo.getFondo());
                panel.add(cell);
                cell.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        cell.setColor(colorActivo);
                    }
                });
            }
        }
        imagen.setPanel(panel);
    }
    
    private void cargarImagenes(TablaDeSimbolos variables) {
        this.InicioImagenesComboBox.removeAllItems();
        this.FinImagensComboBox.removeAllItems();
        this.ImagenActivaComboBox.removeAllItems();
        //faltaria pintar las imagenes si hay archivo pnt
        for (Imagen imagen : this.lienzo.getTiempos().getImagenes()) {
            this.ImagenActivaComboBox.addItem(imagen.getId());
            this.InicioImagenesComboBox.addItem(imagen.getId());
            this.FinImagensComboBox.addItem(imagen.getId());
            if(imagen.getPanel() == null) cargarImagen(imagen);
        }
        if(!this.lienzo.getInstrucciones().isEmpty() && variables != null){
            InstruccionManager manager = new InstruccionManager();
            List<InstruccionPintar> pinturas = new ArrayList<InstruccionPintar>();
            List<String> errores = new ArrayList<String>();
            manager.ejecutarInstrucciones(lienzo.getId(), lienzo.getInstrucciones(), variables, pinturas, errores);
                for (InstruccionPintar pintura : pinturas) {
                    manager.ejecutarPintura(pintura, lienzo);
                }
            if(!errores.isEmpty()){
                String cadena = "";
                for (String error : errores) {
                    cadena+=error+"\n";
                }
                JOptionPane.showMessageDialog(null, cadena, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        int indiceInicio = 0, indiceFinal = 0;
        for (int i = 0; i < this.lienzo.getTiempos().getImagenes().size(); i++) {
            if(this.lienzo.getTiempos().getImagenes().get(i).getId().equals(this.lienzo.getTiempos().getIdInicio())) indiceInicio = i;
            if(this.lienzo.getTiempos().getImagenes().get(i).getId().equals(this.lienzo.getTiempos().getIdFin())) indiceFinal = i;
        }
        this.InicioImagenesComboBox.setSelectedIndex(indiceInicio);
        this.FinImagensComboBox.setSelectedIndex(indiceFinal);
        this.ImagenActivaComboBox.setSelectedIndex(0);
        this.LienzoPane.add(this.lienzo.getTiempos().getImagenes().get(0).getPanel());
    }

    private void cargarColores() {
        this.ColoresComboBox.removeAllItems();
        for (ColorP color : this.lienzo.getColores()) {
            this.ColoresComboBox.addItem(color.getId());
        }
        this.ColoresComboBox.setSelectedIndex(0);
        this.colorActivo = this.lienzo.getColores().get(0);
        this.ColorActivoLabel.setText("Color Activo: "+this.ColoresComboBox.getSelectedItem());
    }
    
    /**
     * Creates new form PanelLienzo
     */
    public PanelLienzo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoAgregarImagen = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IdAgregarImagen = new javax.swing.JTextField();
        DuracionAgregarImagen = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        DialogoAgregarColor = new javax.swing.JDialog();
        ColorAgregarColor = new javax.swing.JColorChooser();
        jLabel7 = new javax.swing.JLabel();
        IdAgregarColor = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        ToolLienzoPane = new javax.swing.JPanel();
        ColoresComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ColorActivoLabel = new javax.swing.JLabel();
        BorradorCheckBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        InicioImagenesComboBox = new javax.swing.JComboBox<>();
        FinImagensComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ImagenActivaComboBox = new javax.swing.JComboBox<>();
        DuracionImagenActivaLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        LienzoPane = new java.awt.ScrollPane();

        DialogoAgregarImagen.setSize(new java.awt.Dimension(420, 190));

        jLabel2.setText("Id de la imagen:");

        jLabel6.setText("Duracion de la imagen:");

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DialogoAgregarImagenLayout = new javax.swing.GroupLayout(DialogoAgregarImagen.getContentPane());
        DialogoAgregarImagen.getContentPane().setLayout(DialogoAgregarImagenLayout);
        DialogoAgregarImagenLayout.setHorizontalGroup(
            DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoAgregarImagenLayout.createSequentialGroup()
                .addGroup(DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogoAgregarImagenLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DuracionAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DialogoAgregarImagenLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton4)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        DialogoAgregarImagenLayout.setVerticalGroup(
            DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoAgregarImagenLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IdAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoAgregarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DuracionAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        DialogoAgregarColor.setSize(new java.awt.Dimension(675, 470));

        ColorAgregarColor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Id color: ");

        jButton5.setText("Agregar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DialogoAgregarColorLayout = new javax.swing.GroupLayout(DialogoAgregarColor.getContentPane());
        DialogoAgregarColor.getContentPane().setLayout(DialogoAgregarColorLayout);
        DialogoAgregarColorLayout.setHorizontalGroup(
            DialogoAgregarColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoAgregarColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DialogoAgregarColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogoAgregarColorLayout.createSequentialGroup()
                        .addComponent(ColorAgregarColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(DialogoAgregarColorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(IdAgregarColor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(66, 66, 66))))
        );
        DialogoAgregarColorLayout.setVerticalGroup(
            DialogoAgregarColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoAgregarColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColorAgregarColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DialogoAgregarColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(IdAgregarColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        ToolLienzoPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Herramientas para el lienzo"));

        ColoresComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColoresComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Colores:");

        ColorActivoLabel.setText("Color Activo: -------------------------------------------");

        BorradorCheckBox.setText("Borrador");
        BorradorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorradorCheckBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar Color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Inicio");

        jLabel4.setText("Fin");

        InicioImagenesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioImagenesComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Imagen Activa");

        ImagenActivaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenActivaComboBoxActionPerformed(evt);
            }
        });

        DuracionImagenActivaLabel.setText("Duracion Imagen Activa: ----------------------");

        jButton3.setText("Exportar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ToolLienzoPaneLayout = new javax.swing.GroupLayout(ToolLienzoPane);
        ToolLienzoPane.setLayout(ToolLienzoPaneLayout);
        ToolLienzoPaneLayout.setHorizontalGroup(
            ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                                        .addComponent(BorradorCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(ColorActivoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel1)
                                        .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(ColoresComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                                                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jLabel3))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel4)))
                                                .addGap(18, 18, 18)
                                                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(InicioImagenesComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(FinImagensComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(ImagenActivaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(27, 27, 27))))
                    .addGroup(ToolLienzoPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DuracionImagenActivaLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ToolLienzoPaneLayout.setVerticalGroup(
            ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolLienzoPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(InicioImagenesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FinImagensComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ImagenActivaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DuracionImagenActivaLabel)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ColoresComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ColorActivoLabel)
                .addGap(18, 18, 18)
                .addGroup(ToolLienzoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BorradorCheckBox)
                    .addComponent(jButton1))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ToolLienzoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LienzoPane, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LienzoPane, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(ToolLienzoPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BorradorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorradorCheckBoxActionPerformed
        if(BorradorCheckBox.isSelected()){
            this.colorActivo = this.lienzo.getFondo();
        }else{
            this.colorActivo = this.lienzo.getColores().get(this.ColoresComboBox.getSelectedIndex());
        }
    }//GEN-LAST:event_BorradorCheckBoxActionPerformed

    private void ColoresComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColoresComboBoxActionPerformed
        if(this.ColoresComboBox.getSelectedIndex()!=(-1)){
            this.colorActivo = this.lienzo.getColores().get(this.ColoresComboBox.getSelectedIndex());
            this.ColorActivoLabel.setText("Color Activo: "+this.colorActivo.getId());
        }
    }//GEN-LAST:event_ColoresComboBoxActionPerformed

    private void ImagenActivaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenActivaComboBoxActionPerformed
        if(this.ImagenActivaComboBox.getSelectedIndex()!=(-1)){
            Imagen imagen = this.lienzo.getTiempos().getImagenes().get(this.ImagenActivaComboBox.getSelectedIndex());
            this.LienzoPane.removeAll();
            if(imagen.getPanel()!=null) {
                this.LienzoPane.add(imagen.getPanel());
                this.DuracionImagenActivaLabel.setText("Duracion Imagen Activa: "+imagen.getDuracion());
            }
        }
    }//GEN-LAST:event_ImagenActivaComboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int indiceInicio = this.InicioImagenesComboBox.getSelectedIndex();
        int indiceFinal = this.FinImagensComboBox.getSelectedIndex();
        if(this.lienzo.getExtension().equals("gif")){
            if(indiceInicio == indiceFinal){
                JOptionPane.showMessageDialog(null, "Al crear un gif, debe haber por lo menos dos imagenes", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if(indiceInicio < indiceFinal){
                    this.exportarGif(indiceInicio, indiceFinal);
                }else{
                    JOptionPane.showMessageDialog(null, "En el orden de impresion", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            if(this.FinImagensComboBox.getItemCount()==0){
                Imagen imagen = this.lienzo.getTiempos().getImagenes().get(this.InicioImagenesComboBox.getSelectedIndex()); //obtenemos la imagen que contiene las celdas a agregar
                imprimirImagen(imagen);
            }else{
                if(indiceInicio != indiceFinal){
                    if(indiceInicio < indiceFinal){
                        for (int i = indiceInicio; i < (indiceFinal+1); i++) {
                            Imagen imagen = this.lienzo.getTiempos().getImagenes().get(i); //obtenemos la imagen que contiene las celdas a agregar
                            imprimirImagen(imagen);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "En el orden de impresion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    Imagen imagen = this.lienzo.getTiempos().getImagenes().get(indiceInicio); //obtenemos la imagen que contiene las celdas a agregar
                    imprimirImagen(imagen);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void InicioImagenesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioImagenesComboBoxActionPerformed
    }//GEN-LAST:event_InicioImagenesComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IdAgregarImagen.setText("");
        DuracionAgregarImagen.setText("");
        DialogoAgregarImagen.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IdAgregarColor.setText("");
        ColorAgregarColor.setColor(null);
        DialogoAgregarColor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(IdAgregarImagen.getText().isEmpty() || DuracionAgregarImagen.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ingreso los datos necesarios", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                int duracion = Integer.parseInt(DuracionAgregarImagen.getText());
                Imagen imagen = new Imagen();
                imagen.setId(IdAgregarImagen.getText());
                imagen.setDuracion(duracion);
                this.lienzo.getTiempos().getImagenes().add(imagen);
                DialogoAgregarImagen.setVisible(false);
                cargarImagenes(null);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No se ingreso un valor entero en duracion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(ColorAgregarColor.getColor() != null){
            if(IdAgregarColor.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No se ingreso un id para el color nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                Color color = ColorAgregarColor.getColor();
                ColorP colorAgregado = new ColorP(color, IdAgregarColor.getText());
                this.lienzo.getColores().add(colorAgregado);
                DialogoAgregarColor.setVisible(false);
                this.cargarColores();
            }
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono un color a agregar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BorradorCheckBox;
    private javax.swing.JLabel ColorActivoLabel;
    private javax.swing.JColorChooser ColorAgregarColor;
    private javax.swing.JComboBox<String> ColoresComboBox;
    private javax.swing.JDialog DialogoAgregarColor;
    private javax.swing.JDialog DialogoAgregarImagen;
    private javax.swing.JTextField DuracionAgregarImagen;
    private javax.swing.JLabel DuracionImagenActivaLabel;
    private javax.swing.JComboBox<String> FinImagensComboBox;
    private javax.swing.JTextField IdAgregarColor;
    private javax.swing.JTextField IdAgregarImagen;
    private javax.swing.JComboBox<String> ImagenActivaComboBox;
    private javax.swing.JComboBox<String> InicioImagenesComboBox;
    private java.awt.ScrollPane LienzoPane;
    private javax.swing.JPanel ToolLienzoPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    private void imprimirImagen(Imagen imagen) {
        JPanel panelApintar = new JPanel(); //es el panel al cual vamos a agregar las celdas que queremos pintar
        panelApintar.setSize(this.lienzo.getCuadros()*this.lienzo.getdY(), this.lienzo.getdX()*this.lienzo.getCuadros());//ajustamos el tamaño del panel
        panelApintar.setLayout(new GridLayout(this.lienzo.getdY(), this.lienzo.getdX()));//agregamos la cuadricula de celdas que va a tener el panel
        for (Component component : imagen.getPanel().getComponents()) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setSize(lienzo.getCuadros(), lienzo.getCuadros());
            label.setBackground(((Cell) component).getBackground());
            panelApintar.add(label);
        }
        JFrame frame = new JFrame();
        frame.setSize(panelApintar.getWidth(), panelApintar.getHeight());
        frame.add(panelApintar);
        frame.setVisible(true);
        BufferedImage pintor = new BufferedImage(panelApintar.getHeight(), panelApintar.getWidth(), BufferedImage.TYPE_INT_RGB);
        panelApintar.paint(pintor.getGraphics());
        frame.dispose();
        try{
            File file = new File("Salidas/"+this.lienzo.getIdSalida());
            if(!file.exists()) file.mkdirs();
            ImageIO.write(pintor, "png", new File("Salidas/"+this.lienzo.getIdSalida()+"/"+imagen.getId()));
        } catch (IOException ex){
            Logger.getLogger(PanelLienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void exportarGif(int indiceInicio, int indiceFinal){
        try {
            File file = new File("Salidas/"+this.lienzo.getIdSalida());
            if(!file.exists()) file.mkdirs();
            for (int i = indiceInicio; i < (indiceFinal+1); i++) {
                Imagen imagen = this.lienzo.getTiempos().getImagenes().get(i); //obtenemos la imagen que contiene las celdas a agregar
                imprimirImagen(imagen);
            }
            BufferedImage first = ImageIO.read(new File("Salidas/"+this.lienzo.getIdSalida()+"/"+this.lienzo.getTiempos().getImagenes().get(indiceInicio).getId()));
            ImageOutputStream output = new FileImageOutputStream(new File("Salidas/"+this.lienzo.getIdSalida()+"/"+this.lienzo.getIdSalida()));
            
            GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
            writer.writeToSequence(first);
            
            List<File> images = new ArrayList<File>();
            for (int i = indiceInicio; i < (indiceFinal+1); i++) {
                images.add(new File("Salidas/"+this.lienzo.getIdSalida()+"/"+this.lienzo.getTiempos().getImagenes().get(i).getId()));
            }
            int i = 0;
            for (File image : images) {
                BufferedImage next = ImageIO.read(image);
                writer.configureRootMetadata(this.lienzo.getTiempos().getImagenes().get(i).getDuracion(), true);
                writer.writeToSequence(next);
                i++;
            }
            
            writer.close();
            output.close();
            
            for (File image : images) {
                image.delete();
            }
        } catch (IOException ex) {
            Logger.getLogger(PanelLienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
