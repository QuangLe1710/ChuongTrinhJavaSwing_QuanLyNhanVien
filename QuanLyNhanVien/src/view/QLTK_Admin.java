package view;


import controller.QLTKListen_Admin;
import controller.QLTKMouseListen_Admin;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.DSPhongBan;
import model.DSTaiKhoan;
import model.PhongBan;
import model.TaiKhoan;

public class QLTK_Admin extends JPanel {
    public JPopupMenu popupMenu;
    public JMenuItem menuItem_Delete;
    public JMenuItem menuItem_Detaild;
    private DSTaiKhoan dsTaiKhoan;
    public DSPhongBan dsPhongBan;
    private String TTK;
    public String matKhau;
    private JButton button_Cancel, button_Create, button_Save, button_Search, button_SearchCancel;
    public JComboBox<String> comboBox_Authority;
    private JScrollPane jScrollPane1;
    private JLabel label_AccountList, label_Authority, label_CreateDay, label_Password, label_UerNameSearch, label_UserName;
    private JSeparator separator_Button, separator_Search;
    public JTable table_Account;
    public JTextField textField_CreateDay, textField_Pasword, textField_UserName;
    private JTextField textField_UserNameSearch;
    
    public QLTK_Admin() {
        this.setView();
        this.setProperty();

    }
    
    private void setProperty() {    
        this.dsTaiKhoan = new DSTaiKhoan();
        this.dsPhongBan = new DSPhongBan();
                
        popupMenu = new JPopupMenu();
        menuItem_Delete = new JMenuItem("Xóa");
        menuItem_Detaild = new JMenuItem("Chi Tiết");
        popupMenu.add(menuItem_Delete);
        popupMenu.add(menuItem_Detaild);
        this.add(popupMenu);
        
        QLTKMouseListen_Admin mouse = new QLTKMouseListen_Admin(this);
        this.table_Account.addMouseListener(mouse);
        
        QLTKListen_Admin lis = new QLTKListen_Admin(this);
        button_Create.addActionListener(lis);
        button_Save.addActionListener(lis);
        button_Cancel.addActionListener(lis);
        menuItem_Delete.addActionListener(lis);
        menuItem_Detaild.addActionListener(lis);
        button_Search.addActionListener(lis);
        button_SearchCancel.addActionListener(lis);
        
        this.ReadFilePB();
        this.ReadFileTK();
        this.checkAuthority();
        for (PhongBan pb : this.dsPhongBan.getDsPB()) {
            comboBox_Authority.addItem(pb.getTenPB());
        }
        comboBox_Authority.addItem("ADMIN");
        comboBox_Authority.addItem("Không Có Quyền");
        comboBox_Authority.setSelectedIndex(-1);
        
        this.DisplayTK(this.dsTaiKhoan.getDsTK());
    }

    
                            
    private void setView() {

        jScrollPane1 = new JScrollPane();
        table_Account = new JTable();
        label_AccountList = new JLabel();
        label_UserName = new JLabel();
        label_Password = new JLabel();
        textField_UserName = new JTextField();
        textField_Pasword = new JTextField();
        label_Authority = new JLabel();
        comboBox_Authority = new JComboBox<>();
        button_Create = new JButton();
        button_Save = new JButton();
        button_Cancel = new JButton();
        label_UerNameSearch = new JLabel();
        textField_UserNameSearch = new JTextField();
        label_CreateDay = new JLabel();
        textField_CreateDay = new JTextField();
        separator_Search = new JSeparator();
        separator_Button = new JSeparator();
        button_Search = new JButton();
        button_SearchCancel = new JButton();
        
        Font font1 = new Font("Segoe UI", 0, 12);
        Font font2 = new Font("Segoe UI", 0, 14);
        Font font3 = new Font("Segoe UI", 0, 18);

        table_Account.setFont(font2); 
        table_Account.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Tài Khoản", "Mật Khẩu", "Quyền", "Ngày Tạo"}) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Account.setRowHeight(25);
        jScrollPane1.setViewportView(table_Account);

        label_AccountList.setFont(font1); 
        label_AccountList.setText("Danh sách tài khoản:");

        label_UserName.setFont(font3); 
        label_UserName.setText("Tên Tài Khoản:");

        label_Password.setFont(font3); 
        label_Password.setText("Mật Khẩu:");

        textField_UserName.setFont(font3); 
        textField_UserName.setEnabled(false);

        textField_Pasword.setFont(font3); 
        textField_Pasword.setEnabled(false);

        label_Authority.setFont(font3); 
        label_Authority.setText("Quyền:");

        comboBox_Authority.setFont(font3); 
        comboBox_Authority.setEnabled(false);

        button_Create.setFont(font3); 
        button_Create.setText("Tạo");

        button_Save.setFont(font3); 
        button_Save.setText("Lưu");

        button_Cancel.setFont(font3); 
        button_Cancel.setText("Hủy Bỏ");

        label_UerNameSearch.setFont(font3); 
        label_UerNameSearch.setText("Tài Khoản:");

        textField_UserNameSearch.setFont(font3); 

        label_CreateDay.setFont(font3); 
        label_CreateDay.setText("Ngày Tạo:");

        textField_CreateDay.setFont(font3); 
        textField_CreateDay.setEnabled(false);

        button_Search.setFont(font3); 
        button_Search.setText("Tìm Kiếm");

        button_SearchCancel.setFont(font3); 
        button_SearchCancel.setText("Hủy");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(label_AccountList))
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(label_UerNameSearch).addGap(18, 18, 18)
                .addComponent(textField_UserNameSearch, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE).addGap(50, 50, 50)
                .addComponent(button_Search).addGap(18, 18, 18)
                .addComponent(button_SearchCancel))
            .addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(label_UserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(textField_UserName, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addComponent(textField_Pasword)).addGap(189, 189, 189)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(label_CreateDay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Authority, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(comboBox_Authority, 0, 230, Short.MAX_VALUE)
                .addComponent(textField_CreateDay)))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(separator_Search, GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 840, GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(4, 4, 4)
                .addComponent(separator_Button))
            .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(button_Cancel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addComponent(button_Save, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(button_Create, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)).addGap(0, 16, Short.MAX_VALUE)))));
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(39, 39, 39)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_UerNameSearch)
                .addComponent(textField_UserNameSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button_Search)
                .addComponent(button_SearchCancel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_Search, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_Save, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(button_Cancel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(separator_Button, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE).addGap(35, 35, 35)
                .addComponent(button_Create, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_AccountList).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_UserName)
                .addComponent(textField_UserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Authority)
                .addComponent(comboBox_Authority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))).addGap(14, 14, 14)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_Password)
                .addComponent(textField_Pasword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_CreateDay)
                .addComponent(textField_CreateDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(85, 85, 85)));
    }                   

    public void setEnable(boolean b) {
        textField_UserName.setEnabled(b);
        textField_Pasword.setEnabled(b);
        comboBox_Authority.setEnabled(b);
    }

    public void xoaForm() {
        textField_UserName.setText("");
        textField_Pasword.setText("");
        comboBox_Authority.setSelectedIndex(-1);
        textField_CreateDay.setText("");
    }
    
    private void checkAuthority() {
        for (TaiKhoan TK : this.dsTaiKhoan.getDsTK()) {
            if(TK.getAuthority().equals("Không Có Quyền") 
                    || TK.getAuthority().equals("ADMIN")) continue;
            boolean check = false;
            for (PhongBan PB : this.dsPhongBan.getDsPB()) {              
                if(TK.getAuthority().equals(PB.getTenPB())) {
                    check = true;
                    break;
                }
            }
            if(!check) TK.setAuthority("Không Có Quyền");
        }
    }
    
    private void DisplayTK(ArrayList<TaiKhoan> DSTK) {
        DefaultTableModel modelTable = new DefaultTableModel();
        table_Account.setModel(modelTable);
        modelTable.addColumn("Tên Tài Khoản");
	modelTable.addColumn("Mật Khẩu");
        modelTable.addColumn("Quyền");
        modelTable.addColumn("Ngày Tạo");
        try {
            for(TaiKhoan TK:DSTK) {
            modelTable.addRow(
                                new Object[] {
                                        TK.getTenTK()+"",
					TK.getMatKhau()+"",	
                                        TK.getAuthority()+"",
					(TK.getNgayTao().getMonth()+1)+"/"+TK.getNgayTao().getDate()+
                                                "/"+(TK.getNgayTao().getYear()+1900)});
                            }
        } catch (Exception e) {
        }
    }

    public boolean themTK(TaiKhoan TK) {
        for (TaiKhoan tk : this.dsTaiKhoan.getDsTK()) {
            if(TK.getTenTK().equals(tk.getTenTK()))  return false;
        }
        dsTaiKhoan.ThemTK(TK);
        this.xoaForm();
        this.setEnable(false);
        this.WriteFileTK();
        DisplayTK(this.dsTaiKhoan.getDsTK());
        JOptionPane.showMessageDialog(this, 
                "Thêm tài khoản thành công!", "Thêm Tài Khoản", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public void capNhatTK(TaiKhoan TK) {     
        this.dsTaiKhoan.CapNhatTK(TK);
        DisplayTK(this.dsTaiKhoan.getDsTK());
        this.xoaForm();     
        this.setEnable(false);
        JOptionPane.showMessageDialog(this, 
                "Đổi mật khẩu thành công!", "Đổi Mật Khẩu", 
                JOptionPane.INFORMATION_MESSAGE);
        this.WriteFileTK();
    }

    public void xoaTK() {
        DefaultTableModel modelTable = (DefaultTableModel) table_Account.getModel();
        int row = table_Account.getSelectedRow();
        
        int luaChon = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa tài khoản này!",
                "Confirm", JOptionPane.ERROR_MESSAGE);
        
        if(luaChon == JOptionPane.YES_OPTION) {
            this.TTK = modelTable.getValueAt(row, 0)+"";
            for(int i = 0; i < this.dsTaiKhoan.getDsTK().size(); i++) {
                if(this.TTK.equals(this.dsTaiKhoan.getDsTK().get(i).getTenTK())) {
                    this.dsTaiKhoan.XoaTK(this.dsTaiKhoan.getDsTK().get(i));
                }
            }
            modelTable.removeRow(row); 
            this.WriteFileTK();
            JOptionPane.showMessageDialog(this, 
                  "Xóa tài khoản thành công!", "Xóa Tài Khoản", 
                 JOptionPane.INFORMATION_MESSAGE);
        }     
    }

    public void hienThiChiTiet() {
        textField_Pasword.setEnabled(true);
        comboBox_Authority.setEnabled(true);
        
        DefaultTableModel modeltable = (DefaultTableModel) table_Account.getModel();
        int row = table_Account.getSelectedRow();
        
        String userName = modeltable.getValueAt(row, 0)+"";
        String passWord = modeltable.getValueAt(row, 1)+"";
        String authority = modeltable.getValueAt(row, 2)+"";
        String createDay = modeltable.getValueAt(row, 3)+"";
        
        matKhau = passWord;
        textField_UserName.setText(userName);
        textField_Pasword.setText(passWord);
        comboBox_Authority.setSelectedItem(authority);
        textField_CreateDay.setText(createDay);
    }

    public void timkiemTK() {
        DisplayTK(this.dsTaiKhoan.getDsTK());
        DefaultTableModel modelTable = (DefaultTableModel) table_Account.getModel();
        int countRow = modelTable.getRowCount();
        String userName = this.textField_UserNameSearch.getText();
        ArrayList<String> idCanXoa = new ArrayList<>();
        
        if(userName.trim().length() > 0) {
            for(int i = 0; i < countRow; i++) {
                String id = modelTable.getValueAt(i, 0)+"";
                if(!id.equals(userName)) {
                    idCanXoa.add(id);
                }
            }
        }
           
        for(String id: idCanXoa) {
            countRow = modelTable.getRowCount();
            for(int i =0; i < countRow; i++) {
                String idTrongBang = modelTable.getValueAt(i, 0)+"";
                if(idTrongBang.equals(id)) {                   
                    try{
                        modelTable.removeRow(i);
                    }
                    catch(Exception e) {
                    }
                    break;
                }
            }
        }
    }

    public void huyTimKiem() {
        textField_UserNameSearch.setText("");
        DisplayTK(this.dsTaiKhoan.getDsTK());
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
            System.err.println("Không tìm thấy file Tài Khoản - QLTJ_Admin");
        }
        this.dsTaiKhoan.setDsTK(taiKhoan);
    }
    
    private void WriteFileTK() {
         try {          
            FileOutputStream fos = new FileOutputStream("taikhoan.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(TaiKhoan tk:this.dsTaiKhoan.getDsTK()) {
                oos.writeObject(tk);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Không tìm thấy file Tài Khoản - QLTK_Admin");
        }
    }
    
     private void ReadFilePB() {
        ArrayList<PhongBan> phongBan = new ArrayList<>();

        try {          
            FileInputStream fis = new FileInputStream("phongban.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                try {
                    Object oj = ois.readObject();
                    if(oj!=null) {
                        PhongBan pb = (PhongBan) oj;
                        phongBan.add(pb);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }  
            }
            ois.close();
        } catch (IOException e) {
            System.err.println("Không tìm thấy file Phòng Ban - QLTK_ Admin");
        }
        this.dsPhongBan.setDsPB(phongBan);
    }
}
