/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author fxhnd
 */

public class InputTab extends JScrollPane{
    
    private String name, extension;
    private File origin;
    private boolean modificado;
    private JTextArea editor;
    private UndoManager undoManager;
    
    public InputTab(String name, File origin) {
        super(new JTextArea());
        this.name = name;
        this.origin = origin;
        this.editor = (JTextArea)super.getViewport().getView();
        undoManager  = new UndoManager();
        addUndoRedoFunctionality();
    }
    
    public InputTab(String name) {
        super(new JTextArea());
        this.name = name;
        this.origin = null;
        this.editor = (JTextArea)super.getViewport().getView();
        undoManager  = new UndoManager();
        addUndoRedoFunctionality();
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }
    
    public JTextArea getTextArea() {
        return editor;
    }
    
    public UndoManager getManager() {
        return undoManager;
    }
    
    public String getText() {
        return editor.getText();
    }
    
    public void setText(String text) {
        this.editor.setText(text);
    }
    
    public String getName() {
        return name;
    }
    
    public File getOrigin() {
        return origin;
    }
    
    public void setOrigin(File origin) {
        this.origin = origin;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public void addUndoRedoFunctionality() {
        editor.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }
    
}
