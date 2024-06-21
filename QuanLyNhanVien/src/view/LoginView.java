package view;


import controller.LoginListen;
import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;
import model.DSTaiKhoan;
import model.TaiKhoan;

public class LoginView extends JFrame {
    public DSTaiKhoan dsTaiKhoan;
    private JButton button_Login;
    public JLabel label_Error;
    private JLabel label_Password, label_Title, label_UserName;
    public JPasswordField passwordField_Password;
    public JTextField textField_UserName;
    
    public LoginView() {
        this.dsTaiKhoan = new  DSTaiKhoan();
        this.setView();
        this.setProperty();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void setProperty() {
        this.ReadFileTK();
        LoginListen lis = new LoginListen(this);
        button_Login.addActionListener(lis);
        
        ImageIcon img = new ImageIcon(getClass().getResource("/icon/QLNV24px.png"));
        this.setIconImage(img.getImage());
        this.setTitle("Employee Manager");
    }
                        
    private void setView() {

        label_UserName = new JLabel();
        label_Password = new JLabel();
        textField_UserName = new JTextField();
        passwordField_Password = new JPasswordField();
        label_Title = new JLabel();
        button_Login = new JButton();
        label_Error = new JLabel();

        Font font = new Font("Segoe UI", 0, 18);
        
        label_UserName.setFont(font); 
        label_UserName.setText("Tài Khoản:");

        label_Password.setFont(font); 
        label_Password.setText("Mật Khẩu:");

        textField_UserName.setFont(font); 

        passwordField_Password.setFont(font);

        label_Title.setFont(font); 
        label_Title.setText("Quản Lý Nhân Viên");

        button_Login.setFont(font); 
        button_Login.setText("Đăng Nhập");

        Color color = new Color(255, 0, 0);
        label_Error.setForeground(color);

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(118, 118, 118)
                .addComponent(label_Title)).addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addComponent(label_UserName).addGap(18, 18, 18)
                .addComponent(textField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup()
                .addComponent(label_Password).addGap(18, 18, 18)
                .addComponent(passwordField_Password, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup()
                .addComponent(label_Error, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Login))))).addContainerGap(62, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(label_Title).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(textField_UserName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_UserName)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_Password)
                .addComponent(passwordField_Password, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label_Error)
                .addComponent(button_Login)).addContainerGap(121, Short.MAX_VALUE)));
        pack();
    }                       

    private void ReadFileTK() {
        ArrayList<TaiKhoan> taiKhoan = new ArrayList<>();

        try {          
            FileInputStream fis = new FileInputStream("taikhoan.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                try {
                    Object oj = ois.readObject();
                    if(oj!=null) {
                        TaiKhoan tk = (TaiKhoan) oj;
                        taiKhoan.add(tk);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }  
            }
            ois.close();
        } catch (IOException e) {
            System.err.println("Không tìm thấy file Tài Khoản - LoginView");
        }
        this.dsTaiKhoan.setDsTK(taiKhoan);
    }
 
    public TaiKhoan checkLogin(TaiKhoan TK) {
        for (TaiKhoan tk : this.dsTaiKhoan.getDsTK()) {
            if(TK.getTenTK().equals(tk.getTenTK()) 
                    && TK.getMatKhau().equals(tk.getMatKhau())) return tk;   
        }
        return null;       
    }
}
