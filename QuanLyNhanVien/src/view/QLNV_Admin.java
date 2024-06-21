package view;


import controller.QLNVListen_Admin;
import controller.QLNVMouseListen_Admin;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.DSPhongBan;
import model.NhanVien;
import model.PhongBan;
import model.DSNhanVien;
import model.Tinh;

public final class QLNV_Admin extends JPanel {
    public ButtonGroup buttonGroup;
    public JPopupMenu popupMenu;
    public JMenuItem menuItem_Delete;
    public JMenuItem menuItem_Detaild;
    private int MNV;
    public String TenPB;
    public DSNhanVien model;
    public DSPhongBan dsPhongBan;
    private JButton button_Add, button_Cancel, button_OK, button_Save, button_Search, button_SearchCancel;
    public JComboBox<String> comboBox_Address, comboBox_Department, comboBox_Position;
    private JScrollPane jScrollPane1;
    private JLabel label_Address, label_BasicSalary, label_DepartmentSearch, label_DoB, label_Gender;
    private JLabel label_MNV, label_MNVSearch, label_Name, label_Position, label_Salary, label_StaffList, label_StartDay;
    public JRadioButton radioButton_Female, radioButton_Male;
    private JSeparator separator_Button, separator_Staff;
    public JTable table_Staff;
    public JTextField textField_BasicSalary, textField_DoB, textField_MNV, textField_Name, textField_StartDay;
    private JTextField textField_MNVSearch, textField_Salary;

    
    public QLNV_Admin() {
        this.setView();
        this.setProperty();
        DisplayNV(this.model.getDsNV());
    }
    
    private void setProperty() {
        this.model = new DSNhanVien();
        this.dsPhongBan = new DSPhongBan();
        
        ArrayList<Tinh> TinhList = Tinh.getDSTinh();
        for (Tinh t : TinhList) {
            comboBox_Address.addItem(t.getTenTinh());
        }
        comboBox_Address.setSelectedIndex(-1);
        
        String[] listPosition = {"Giám Đốc","Thư Ký", "Trưởng Phòng", "Phó Phòng",
                                    "Nhân Viên", "Thực Tập", "Khác..."};
        for (String vt : listPosition) {
            comboBox_Position.addItem(vt);
        }
        this.comboBox_Position.setSelectedIndex(-1);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton_Male);
        buttonGroup.add(radioButton_Female);
        
        popupMenu = new JPopupMenu();
        menuItem_Delete = new JMenuItem("Xóa");
        menuItem_Detaild = new JMenuItem("Chi Tiết");
        popupMenu.add(menuItem_Delete);
        popupMenu.add(menuItem_Detaild);
        this.add(popupMenu);
        
        QLNVMouseListen_Admin mouse = new QLNVMouseListen_Admin(this);
        this.table_Staff.addMouseListener(mouse);
        
        QLNVListen_Admin con = new QLNVListen_Admin(this);
        button_Save.addActionListener(con);
        button_Cancel.addActionListener(con);
        button_Add.addActionListener(con);
        button_Search.addActionListener(con);
        button_SearchCancel.addActionListener(con);
        button_OK.addActionListener(con);
        menuItem_Delete.addActionListener(con);
        menuItem_Detaild.addActionListener(con);
        
        this.ReadFilePB();
        this.ReadFileNV();
        this.checkDepartment();
        for (PhongBan pb : this.dsPhongBan.getDsPB()) {
            comboBox_Department.addItem(pb.getTenPB());
        }
        comboBox_Department.addItem("Không Có Phòng Ban");
        comboBox_Department.addItem("Tất Cả");
        comboBox_Department.setSelectedItem("Tất Cả");
        this.TenPB = "Tất Cả";
    }

                           
    private void setView() {
        jScrollPane1 = new JScrollPane();
        table_Staff = new JTable();
        label_MNVSearch = new JLabel();
        textField_MNVSearch = new JTextField();
        label_DepartmentSearch = new JLabel();
        comboBox_Department = new JComboBox<>();
        separator_Staff = new JSeparator();
        label_StaffList = new JLabel();
        button_Search = new JButton();
        label_MNV = new JLabel();
        label_DoB = new JLabel();
        textField_MNV = new JTextField();
        label_Gender = new JLabel();
        textField_Name = new JTextField();
        textField_DoB = new JTextField();
        radioButton_Male = new JRadioButton();
        radioButton_Female = new JRadioButton();
        label_Address = new JLabel();
        comboBox_Address = new JComboBox<>();
        label_Position = new JLabel();
        label_StartDay = new JLabel();
        label_BasicSalary = new JLabel();
        comboBox_Position = new JComboBox<>();
        textField_StartDay = new JTextField();
        textField_BasicSalary = new JTextField();
        label_Name = new JLabel();
        label_Salary = new JLabel();
        textField_Salary = new JTextField();
        button_Save = new JButton();
        button_Cancel = new JButton();
        button_Add = new JButton();
        separator_Button = new JSeparator();
        button_OK = new JButton();
        button_SearchCancel = new JButton();
        
        Font font1 = new Font("Segoe UI", 0, 12);
        Font font2 = new Font("Segoe UI", 0, 14);
        Font font3 = new Font("Segoe UI", 0, 18);

        table_Staff.setFont(font2); 
        table_Staff.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ",
                "Phòng Ban", "Chức Vụ", "Ngày Vào Làm", "Lương Cơ Bản"}
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Staff.setRowHeight(25);
        jScrollPane1.setViewportView(table_Staff);
        if (table_Staff.getColumnModel().getColumnCount() > 0) {
            table_Staff.getColumnModel().getColumn(0).setResizable(false);
        }

        label_MNVSearch.setFont(font2); 
        label_MNVSearch.setText("Mã Nhân Viên:");

        textField_MNVSearch.setFont(font2); 

        label_DepartmentSearch.setFont(font2);
        label_DepartmentSearch.setText("Phòng Ban:");

        comboBox_Department.setFont(font2); 

        label_StaffList.setFont(font1); 
        label_StaffList.setText("Danh sách nhân viên:");

        button_Search.setFont(font3);
        button_Search.setText("Tìm Kiếm");

        label_MNV.setFont(font2); 
        label_MNV.setText("Mã Nhân Viên:");

        label_DoB.setFont(font2); 
        label_DoB.setText("Ngày Sinh:");

        textField_MNV.setFont(font2);
        textField_MNV.setEnabled(false);

        label_Gender.setFont(font2); 
        label_Gender.setText("Giới Tính: ");

        textField_Name.setFont(font2); 
        textField_Name.setEnabled(false);

        textField_DoB.setFont(font2); 
        textField_DoB.setEnabled(false);

        radioButton_Male.setFont(font2); 
        radioButton_Male.setText("Nam");
        radioButton_Male.setEnabled(false);

        radioButton_Female.setFont(font2); 
        radioButton_Female.setText("Nữ");
        radioButton_Female.setEnabled(false);

        label_Address.setFont(font2);
        label_Address.setText("Địa Chỉ:");

        comboBox_Address.setFont(font2);
        comboBox_Address.setEnabled(false);

        label_Position.setFont(font2); 
        label_Position.setText("Chức Vụ:");

        label_StartDay.setFont(font2); 
        label_StartDay.setText("Ngày Vào Làm:");

        label_BasicSalary.setFont(font2); 
        label_BasicSalary.setText("Lương Cơ Bản:");

        comboBox_Position.setFont(font2);
        comboBox_Position.setEnabled(false);

        textField_StartDay.setFont(font2); 
        textField_StartDay.setEnabled(false);

        textField_BasicSalary.setFont(font2); 
        textField_BasicSalary.setEnabled(false);

        label_Name.setFont(font2); 
        label_Name.setText("Họ và Tên:");

        label_Salary.setFont(font2);
        label_Salary.setText("Tổng Lương:");

        textField_Salary.setFont(font2);
        textField_Salary.setEnabled(false);

        button_Save.setFont(font2);
        button_Save.setText("Lưu");

        button_Cancel.setFont(font2); 
        button_Cancel.setText("Hủy Bỏ");

        button_Add.setFont(font2);
        button_Add.setText("Thêm");

        button_OK.setFont(font2); 
        button_OK.setText("OK");

        button_SearchCancel.setFont(font3); 
        button_SearchCancel.setText("Hủy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separator_Staff, javax.swing.GroupLayout.Alignment.TRAILING)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(label_MNV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_DoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_Name, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(textField_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(textField_MNV)
            .addComponent(textField_DoB, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)).addGap(39, 39, 39)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(label_Address, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_Gender, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
            .addComponent(label_Position, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(comboBox_Address, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
            .addComponent(comboBox_Position, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createSequentialGroup()
            .addComponent(radioButton_Male).addGap(40, 40, 40)
            .addComponent(radioButton_Female))).addGap(37, 37, 37)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(label_BasicSalary)
            .addComponent(label_Salary, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)).addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(textField_BasicSalary, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
            .addComponent(textField_Salary, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
        .addGroup(layout.createSequentialGroup()
            .addComponent(label_StartDay).addGap(18, 18, 18)
            .addComponent(textField_StartDay, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(label_StaffList))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 840, GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_Save, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Cancel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(20, 20, 20))
        .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(separator_Button).addContainerGap())))
        .addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
            .addComponent(label_MNVSearch).addGap(18, 18, 18)
            .addComponent(textField_MNVSearch, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
            .addComponent(button_Search).addGap(18, 18, 18)
            .addComponent(button_SearchCancel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_DepartmentSearch).addGap(18, 18, 18)
            .addComponent(comboBox_Department, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
            .addComponent(button_OK).addGap(71, 71, 71)));
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_MNVSearch)
                .addComponent(textField_MNVSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_DepartmentSearch)
                .addComponent(comboBox_Department, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(button_Search)
                .addComponent(button_OK)
                .addComponent(button_SearchCancel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_Staff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(label_StaffList)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE).addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                .addComponent(label_Name).addGap(24, 24, 24)
                .addComponent(label_DoB))
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(textField_MNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Gender)
                .addComponent(radioButton_Male)
                .addComponent(radioButton_Female)
                .addComponent(label_StartDay)
                .addComponent(textField_StartDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_MNV)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(textField_Name, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Address)
                .addComponent(comboBox_Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_BasicSalary)
                .addComponent(textField_BasicSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(textField_DoB, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Position)
                .addComponent(comboBox_Position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_Salary,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Salary))))).addGroup(layout.createSequentialGroup().addGap(19, 19, 19)
                .addComponent(button_Save, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(button_Cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(23, 23, 23)
                .addComponent(separator_Button, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(button_Add, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))).addContainerGap(113, Short.MAX_VALUE)));
    }                      

    public void setEnable(boolean b) {
        textField_MNV.setEnabled(b);
        textField_Name.setEnabled(b);
        textField_DoB.setEnabled(b);
        radioButton_Male.setEnabled(b);
        radioButton_Female.setEnabled(b);
        comboBox_Address.setEnabled(b);
        comboBox_Position.setEnabled(b);
        textField_StartDay.setEnabled(b);
        textField_BasicSalary.setEnabled(b);
    }
    
    public void xoaForm()  {
        textField_MNV.setText("");
        textField_Name.setText("");
        textField_DoB.setText("");
        buttonGroup.clearSelection();
        comboBox_Address.setSelectedIndex(-1);
        comboBox_Position.setSelectedIndex(-1);
        textField_StartDay.setText("");
        textField_BasicSalary.setText("");      
        textField_Salary.setText("");
    }
    
    private void checkDepartment() {
        for (NhanVien NV : this.model.getDsNV()) {
            if(NV.getPhongBan().getTenPB().equals("Không Có Phòng Ban"))   continue;
            PhongBan pb = new PhongBan(null, "Không Có Phòng Ban", null);
            boolean check = false;
            for (PhongBan PB : this.dsPhongBan.getDsPB()) {
                if(NV.getPhongBan().getTenPB().equals(PB.getTenPB())) {
                    check = true;                    
                    break;
                }
            }
            if(!check) {
                NV.setPhongBan(pb);
                NV.setChucVu("Khác...");
            }
        }
    }
    
    public void DisplayNV(ArrayList<NhanVien> dsNV) {
        DefaultTableModel modelTable = new DefaultTableModel();
        table_Staff.setModel(modelTable);
        modelTable.addColumn("ID");
	modelTable.addColumn("Họ Tên");
        modelTable.addColumn("Ngày Sinh");
        modelTable.addColumn("Giới Tính");
        modelTable.addColumn("Địa Chỉ");
        modelTable.addColumn("Phòng Ban");
        modelTable.addColumn("Chức Vụ");
        modelTable.addColumn("Ngày Vào Làm");
        modelTable.addColumn("Lương Cơ Bản");
	try {
            if(this.TenPB.equals("Tất Cả")) {
                for(NhanVien NV:dsNV) {
                    modelTable.addRow(
                                new Object[] {
                                        NV.getMaNV()+"",
					NV.getTenNV()+"",					
					(NV.getNgaySinh().getMonth()+1)+"/"+NV.getNgaySinh().getDate()+
                                                "/"+(NV.getNgaySinh().getYear()+1900),			
                                        (NV.isGioiTinh()?"Nam":"Nữ"),
                                        NV.getDiaChi().getTenTinh(),
					NV.getPhongBan().getTenPB()+"",
					NV.getChucVu()+"",
					(NV.getNgayVaoLam().getMonth()+1)+"/"+NV.getNgayVaoLam().getDate()+
                                                "/"+(NV.getNgayVaoLam().getYear()+1900),			
                                        NV.getLuongCB()+""});
               
                }
            }
            
            else {
                for(NhanVien NV:dsNV) {
                    if(this.TenPB.equals(NV.getPhongBan().getTenPB())) {
                         modelTable.addRow(
                                     new Object[] {
                                             NV.getMaNV()+"",
                                             NV.getTenNV()+"",					
                                             (NV.getNgaySinh().getMonth()+1)+"/"+NV.getNgaySinh().getDate()+
                                                     "/"+(NV.getNgaySinh().getYear()+1900),			
                                             (NV.isGioiTinh()?"Nam":"Nữ"),
                                             NV.getDiaChi().getTenTinh(),
                                             NV.getPhongBan().getTenPB()+"",
                                             NV.getChucVu()+"",
                                             (NV.getNgayVaoLam().getMonth()+1)+"/"+NV.getNgayVaoLam().getDate()+
                                                     "/"+(NV.getNgayVaoLam().getYear()+1900),			
                                             NV.getLuongCB()+""});
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Danh sách nhân viên null - QLNVAdmin");
        }
    }
    
    public boolean themNV(NhanVien NV) {
        for (NhanVien nv : this.model.getDsNV()) {
            if(NV.getMaNV() == nv.getMaNV())  return false;
        }
        model.ThemNV(NV);
        this.xoaForm();
        this.setEnable(false);
        DisplayNV(this.model.getDsNV());
        this.WriteFileNV();
        JOptionPane.showMessageDialog(this, 
                "Thêm nhân viên thành công!", "Thêm Nhân Viên", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
   

    public void xoaNV() {
        DefaultTableModel modelTable = (DefaultTableModel) table_Staff.getModel();
        int row = table_Staff.getSelectedRow();
        
        int luaChon = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa nhân viên này!",
                "Confirm", JOptionPane.ERROR_MESSAGE);
        
        if(luaChon == JOptionPane.YES_OPTION) {
            this.MNV = Integer.parseInt(modelTable.getValueAt(row, 0)+"");
            for(int i = 0; i < this.model.getDsNV().size(); i++) {
                if(this.model.getDsNV().get(i).getMaNV() == this.MNV) {
                    this.model.XoaNV(this.model.getDsNV().get(i));
                }
            }
            modelTable.removeRow(row);
            this.WriteFileNV();
            JOptionPane.showMessageDialog(this, 
                  "Xóa nhân viên thành công!", "Xóa Nhân Viên", 
                 JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public void hienThiChiTiet() {
        this.setEnable(true);
        DefaultTableModel modeltable = (DefaultTableModel) table_Staff.getModel();
        int row = table_Staff.getSelectedRow();
        
        int maNV = Integer.parseInt(modeltable.getValueAt(row, 0)+"");
        String tenNV = modeltable.getValueAt(row, 1)+"";
        String ngaySinh = modeltable.getValueAt(row, 2)+"";
        String chonGT = modeltable.getValueAt(row, 3)+"";
        Tinh tinh = Tinh.getTinhByName(modeltable.getValueAt(row, 4)+"");
        String chucVu = modeltable.getValueAt(row, 6)+"";
        String ngayVaoLam = modeltable.getValueAt(row, 7)+"";
        double luongCB = Double.parseDouble(modeltable.getValueAt(row, 8)+"");
        String phongBan  = modeltable.getValueAt(row, 5)+"";
        
        textField_MNV.setText(maNV+"");
        textField_Name.setText(tenNV);
        textField_DoB.setText(ngaySinh);   
        if(chonGT.equals("Nam"))  radioButton_Male.setSelected(true);
        else  radioButton_Female.setSelected(true);   
        comboBox_Address.setSelectedItem(tinh.getTenTinh());
        comboBox_Position.setSelectedItem(chucVu);
        textField_StartDay.setText(ngayVaoLam);
        textField_BasicSalary.setText(luongCB+"");
        comboBox_Department.setSelectedItem(phongBan);
        
        Date dateOfWork = new Date(ngayVaoLam);
        int workYear = dateOfWork.getYear()+1900;
        
        LocalDate persentDate = LocalDate.now();
        int nowYear = persentDate.getYear();
              
        double heSoLuong = HeSoLuong(chucVu, nowYear-workYear);
        double tongLuong = luongCB * heSoLuong;       
        DecimalFormat df = new DecimalFormat("#.##"); 
        String formattedNumber = df.format(tongLuong);   
        this.textField_Salary.setText(formattedNumber.replace(',', '.'));
        
        this.MNV = maNV;
    }

    private double HeSoLuong(String position, int year) {
        double heSo;      
        heSo = switch (position) {
            case "Giám Đốc" -> 2;
            case "Thư Ký" -> 1.5;
            case "Trưởng Phòng" -> 1.7;
            case "Phó Phòng" -> 1.4;
            case "Nhân Viên" -> 1.2;
            case "Thực Tập" -> 0.8;
            default -> 1;
        };       
        if(year <= 0)   return heSo;
        else if(year > 0 && year <= 3)  return heSo*1.3;
        else if(year > 3 && year <= 7)  return heSo*1.5;
        else if(year > 7 && year <= 10) return heSo*1.7;
        else     return heSo*2;
    }

    public boolean capNhatNV(NhanVien NV) {
        DisplayNV(this.model.getDsNV());
        for (NhanVien nv : this.model.getDsNV()) {
            if(NV.getMaNV() == nv.getMaNV() && NV.getMaNV() != this.MNV )   return false;
        }
        this.model.CapNhatNV(this.MNV, NV);
        DisplayNV(this.model.getDsNV());
        this.xoaForm();
        this.setEnable(false);
        this.WriteFileNV();
        JOptionPane.showMessageDialog(this, 
                "Cập nhật thông tin nhân viên thành công!", "Cập Nhật Thông Tin", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public void timKiemNV() {
        DisplayNV(this.model.getDsNV());
        DefaultTableModel modelTable = (DefaultTableModel) table_Staff.getModel();
        int countRow = modelTable.getRowCount();
        String maNV = this.textField_MNVSearch.getText();
        ArrayList<String> idCanXoa = new ArrayList<>();
        
        if(maNV.length() > 0) {
            for(int i = 0; i < countRow; i++) {
                String id = modelTable.getValueAt(i, 0)+"";
                if(!id.equals(maNV)) {
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
        textField_MNVSearch.setText("");
        DisplayNV(this.model.getDsNV());
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
            System.err.println("Lỗi đọc file Phòng Ban - QLNV_Admin");
        }
        this.dsPhongBan.setDsPB(phongBan);
    }
    
    private void ReadFileNV() {
        ArrayList<NhanVien> nhanVien = new ArrayList<>();
        try {                     
            FileInputStream fis = new FileInputStream("nhanvien.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                try {
                    Object oj = ois.readObject();
                    if(oj!=null) {
                        NhanVien nv = (NhanVien) oj;
                        nhanVien.add(nv);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }  
            }
            ois.close();
        } catch (IOException e) {
            System.err.println("Lỗi đọc file Nhân Viên - QLNV_Admin");
        }
        this.model.setDsNV(nhanVien);       
    }
    
    private void WriteFileNV() {
        try {       
            FileOutputStream fos = new FileOutputStream("nhanvien.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(NhanVien nv:this.model.getDsNV()) {
                oos.writeObject(nv);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file Nhân Viên - dòng 1102");
        }
    }
}
