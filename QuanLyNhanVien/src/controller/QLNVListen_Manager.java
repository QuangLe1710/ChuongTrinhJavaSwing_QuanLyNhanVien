package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.NhanVien;
import model.PhongBan;
import model.Tinh;
import view.QLNV_Manager;

public class QLNVListen_Manager implements ActionListener{
    private final QLNV_Manager view;
    private String status;

    public QLNVListen_Manager(QLNV_Manager view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        switch (s) {
            case "Thêm" -> {
                this.view.setEnable(true);
                this.status = s;
            }
            case "Lưu" -> {
                
                int maNV = Integer.parseInt(this.view.textField_MNV.getText());
                String tenNV = this.view.textField_Name.getText();
                Date ngaySinh = new Date(this.view.textField_DoB.getText());
                String chucVu = this.view.comboBox_Position.getSelectedItem()+"";
                boolean gioiTinh = true;
                if(this.view.radioButton_Male.isSelected())         gioiTinh = true;
                else if(this.view.radioButton_Female.isSelected())  gioiTinh = false;
                int queQuan = this.view.comboBox_Address.getSelectedIndex();
                Tinh tinh = Tinh.getTinhByID(queQuan);
                Date ngayVaoLam = new Date(this.view.textField_StartDay.getText());
                double luongCB = Double.parseDouble(this.view.textField_BasicSalary.getText());
                PhongBan phongBan = this.view.phongBan;
                
                NhanVien NV = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, tinh, phongBan, chucVu, ngayVaoLam, luongCB);
                
                if(this.status.equals("Thêm")){
                    boolean b = this.view.themNV(NV);
                    if(!b) JOptionPane.showMessageDialog(view,
                            "Mã nhân viên đã tồn tại", "Eror", JOptionPane.ERROR_MESSAGE);
                }
                else if(this.status.equals("Chi Tiết")){
                    boolean b = this.view.capNhatNV(NV);
                    if(!b) JOptionPane.showMessageDialog(view,
                            "Mã nhân viên đã tồn tại", "Eror", JOptionPane.ERROR_MESSAGE);
                    else   this.status = "";
                }
            }
            case "Hủy Bỏ" -> {
                this.view.xoaForm();
                this.view.setEnable(false);
            }
            case "Xóa" -> this.view.xoaNV();
            case "Chi Tiết" -> {
                this.view.hienThiChiTiet();
                this.status = s;
            }
            case "Tìm Kiếm" -> this.view.timKiemNV();
            case "Hủy" -> this.view.huyTimKiem();
            default -> {
            }
        }
    }
    
}
