package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.PhongBan;
import view.QLPB_Admin;

public class QLPBListen_Admin implements ActionListener{
    private final QLPB_Admin view;
    private String status;

    public QLPBListen_Admin(QLPB_Admin view) {
        this.view = view;
        this.status = "";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        switch (s) {
            case "Thêm" -> {
                this.view.setEnable(true);
                this.status = s; // this.status = "Thêm"
            }
            case "Lưu" -> {
                try {
                    String maBP = this.view.textField_MPB.getText();
                    String tenBP = this.view.textField_Name.getText();
                    Date ngayThanhLap = new Date(this.view.textField_Found.getText());
                    PhongBan PB = new PhongBan(maBP, tenBP, ngayThanhLap);
                    if(this.status.equals("Thêm")){
                        boolean b = this.view.themPB(PB);
                        if(!b) JOptionPane.showMessageDialog(view,
                                "Mã phòng ban đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(this.status.equals("Chi Tiết")){
                        boolean b = this.view.capNhatPB(PB);
                        if(!b) JOptionPane.showMessageDialog(view,
                                "Mã phòng ban đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
                        else   this.status = "";
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view,
                            "Lỗi dữ liệu", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            case "Hủy Bỏ" -> {
                this.view.xoaForm();
                this.view.setEnable(false);
            }
            case "Xóa" -> this.view.xoaPB();
            case "Chi Tiết" -> {
                this.view.hienThiChiTiet();
                this.status = s; // this.status = "CHi Tiết"
            }
            case "Tìm Kiếm" -> this.view.timKiemPB();
            case "Hủy" -> this.view.huyTimKiem();
            default -> {
            }
        }
    }
    
}
