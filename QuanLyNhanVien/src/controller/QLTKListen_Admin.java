package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.TaiKhoan;
import view.QLTK_Admin;

public class QLTKListen_Admin implements ActionListener{
    private final QLTK_Admin view;
    private String status;

    public QLTKListen_Admin(QLTK_Admin view) {
        this.view = view;
        this.status = "";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "Tạo" -> {
                this.view.setEnable(true);
                this.status = s;
            }
            case "Lưu" -> {
                String tenTK = this.view.textField_UserName.getText();
                String matKhau = this.view.textField_Pasword.getText();
                String quyen = this.view.comboBox_Authority.getSelectedItem()+"";
                if(matKhau.length() < 5) JOptionPane.showMessageDialog(view, 
                            "Mật khẩu phải có từ 5 ký tự trở lên", "Error", JOptionPane.ERROR_MESSAGE);
                
                else {
                    if(this.status.equals("Tạo")){
                        Date ngayTao = new Date();
                        TaiKhoan  TK = new TaiKhoan(tenTK, matKhau, quyen  , ngayTao);              
                        boolean b = this.view.themTK(TK);
                        if(!b) JOptionPane.showMessageDialog(view,
                              "Tài khoản đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);                
                    }
                    else if(this.status.equals("Chi Tiết")){
                        if(this.view.matKhau.equals(matKhau)) {
                            JOptionPane.showMessageDialog(view, 
                                    "Mật khẩu mới không được trùng với mật khẩu cũ", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {                          
                        Date ngayTao = new Date(this.view.textField_CreateDay.getText());
                        TaiKhoan  TK = new TaiKhoan(tenTK, matKhau, quyen, ngayTao);
                        this.view.capNhatTK(TK);
                        this.status = "";
                        }
                    }
                }
            }
            case "Hủy Bỏ" -> {
                this.view.xoaForm();
                this.view.setEnable(false);
            }
            case "Xóa" -> this.view.xoaTK();
            case "Chi Tiết" -> {
                this.view.setEnable(false);
                this.view.hienThiChiTiet();
                this.status = s;
            }
            case "Tìm Kiếm" -> this.view.timkiemTK();
            case "Hủy" -> this.view.huyTimKiem();
            default -> {
            }
        }
    }
    
}
