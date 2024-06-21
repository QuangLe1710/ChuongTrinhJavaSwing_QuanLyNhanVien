package controller;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import execute.QLNVMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginView;
import view.QLNV_Admin;
import view.QLPB_Admin;
import view.QLTK_Admin;

public class MainListen implements ActionListener {
    private QLNVMain view;

    public MainListen(QLNVMain view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        switch (s) {
            case "Log Out" -> {
                this.view.dispose();
                LoginView  loginView = new LoginView();
            }
            case "Show Staff" -> this.view.editPanel(new QLNV_Admin());
            case "Show Department" -> this.view.editPanel(new QLPB_Admin());
            case "Show Account" -> this.view.editPanel(new QLTK_Admin());
            case "About" -> JOptionPane.showMessageDialog(view, "Phần mềm quản lý nhân viên"
                        , "About", JOptionPane.INFORMATION_MESSAGE);
            case "Exit" -> {
                int Confirm = JOptionPane.showConfirmDialog(view,
                        "Bạn có muốn thoát chương trình", "THOÁT",
                        JOptionPane.ERROR_MESSAGE);
                if(Confirm == JOptionPane.YES_OPTION) System.exit(0);
            }
            default -> {
            }
        }
    }
    
}