/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import view.*;



public class QLTKMouseListen_Admin implements MouseListener{
    private final QLTK_Admin view;

    public QLTKMouseListen_Admin(QLTK_Admin view) {
        this.view = view;
    } 
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int r = this.view.table_Account.rowAtPoint(e.getPoint());
        if (r >= 0 && r < this.view.table_Account.getRowCount()) {
            this.view.table_Account.setRowSelectionInterval(r, r);
        } 
        else {
            this.view.table_Account.clearSelection();
        }
        int rowindex = this.view.table_Account.getSelectedRow();
        if (rowindex < 0)
            return;
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
            this.view.popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
