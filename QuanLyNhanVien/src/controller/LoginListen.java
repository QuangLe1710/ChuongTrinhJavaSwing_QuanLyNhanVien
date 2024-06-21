package controller;

import execute.QLNVMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import model.PhongBan;
import model.TaiKhoan;
import view.LoginView;
import view.QLNV_Admin;
import view.QLNV_Manager;

public class LoginListen implements ActionListener{
    private final LoginView view;

    public LoginListen(LoginView view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = view.textField_UserName.getText();

        char[] passwordChars = view.passwordField_Password.getPassword();
        String password = new String(passwordChars);
        Arrays.fill(passwordChars, '0');
        if(userName.trim().length() == 0 || password.trim().length() == 0) {
            this.view.label_Error.setText("Yêu cầu nhập đủ dữ liệu");
        }
        else {
            TaiKhoan TK = new TaiKhoan(userName, password, null, null);
            TaiKhoan tk = this.view.checkLogin(TK);
            if(tk != null)   {
                this.view.dispose();
                if(tk.getAuthority().equals("ADMIN")) {
                    QLNV_Admin component = new QLNV_Admin();
                    QLNVMain qlnvMain = new QLNVMain(component);  
                }
                else {
                    PhongBan phongBan = new PhongBan(null, tk.getAuthority(), null);
                    QLNV_Manager component = new QLNV_Manager(phongBan);
                    QLNVMain qLNVMain = new QLNVMain(component);
                    qLNVMain.menuView.setEnabled(false);
                }
            }
            else this.view.label_Error.setText("Tài khoản hoặc mật khẩu bị sai");
        }          
    }
    
}
