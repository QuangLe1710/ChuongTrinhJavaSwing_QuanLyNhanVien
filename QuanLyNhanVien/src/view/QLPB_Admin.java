package view;

import controller.*;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;

public class QLPB_Admin extends javax.swing.JPanel {
    public JPopupMenu popupMenu;
    public JMenuItem menuItem_Delete;
    public JMenuItem menuItem_Detaild;
    private String MPB;
    private DSPhongBan dsPhongBan;
    private DSNhanVien dsNhanVien;
    private JButton button_Add, button_Cancel, button_Save, button_Search, button_SearchCancel;
    private JScrollPane jScrollPane1;
    private JLabel label_DepartmentList, label_Employes, label_Found, label_MPB, label_MPBSearch, label_Name;
    private JSeparator separator_Button, separator_Search;
    public JTable table_Department;
    public JTextField textField_Found, textField_MPB, textField_Name;
    private JTextField textField_Employes, textField_MPBSearch;
    
    public QLPB_Admin() {
        this.setView();
        this.setProperty();
    }
    
    private void setProperty() { 
        this.dsPhongBan = new DSPhongBan();
        this.dsNhanVien = new DSNhanVien();
        
        popupMenu = new JPopupMenu();
        menuItem_Delete = new JMenuItem("Xóa");
        menuItem_Detaild = new JMenuItem("Chi Tiết");
        popupMenu.add(menuItem_Delete);
        popupMenu.add(menuItem_Detaild);
        this.add(popupMenu);
        
        QLPBMouseListen_Admin mouse = new QLPBMouseListen_Admin(this);
        this.table_Department.addMouseListener(mouse);
        
        QLPBListen_Admin lis = new QLPBListen_Admin(this);
        button_Add.addActionListener(lis);
        button_Search.addActionListener(lis);
        button_SearchCancel.addActionListener(lis);
        button_Save.addActionListener(lis);
        button_Cancel.addActionListener(lis);
        menuItem_Delete.addActionListener(lis);
        menuItem_Detaild.addActionListener(lis);
             
        this.ReadFilePB();
        this.ReadFileNV();
        DisplayPB(this.dsPhongBan.getDsPB());
    }
                  
    private void setView() {
        jScrollPane1 = new JScrollPane();
        table_Department = new JTable();
        label_DepartmentList = new JLabel();
        label_MPB = new JLabel();
        label_Found = new JLabel();
        textField_MPB = new JTextField();
        textField_Name = new JTextField();
        textField_Found = new JTextField();
        label_Employes = new JLabel();
        label_Name = new JLabel();
        textField_Employes = new JTextField();
        button_Save = new JButton();
        button_Cancel = new JButton();
        separator_Button = new JSeparator();
        button_Add = new JButton();
        label_MPBSearch = new JLabel();
        textField_MPBSearch = new JTextField();
        button_Search = new JButton();
        button_SearchCancel = new JButton();
        separator_Search = new JSeparator();
        
        Font font1 = new Font("Segoe UI", 0, 12);
        Font font2 = new Font("Segoe UI", 0, 14);
        Font font3 = new Font("Segoe UI", 0, 18);

        table_Department.setFont(font2); 
        table_Department.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã Phòng Ban", "Tên Phòng  Ban", "Ngày Thành Lập"}
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Department.setRowHeight(25);
        jScrollPane1.setViewportView(table_Department);

        label_DepartmentList.setFont(font1); 
        label_DepartmentList.setText("Danh sách phòng ban:");

        label_MPB.setFont(font3); 
        label_MPB.setText("Mã Phòng Ban:");

        label_Found.setFont(font3); 
        label_Found.setText("Ngày Thành Lập:");

        textField_MPB.setFont(font3); 
        textField_MPB.setEnabled(false);

        textField_Name.setFont(font3); 
        textField_Name.setEnabled(false);

        textField_Found.setFont(font3); 
        textField_Found.setEnabled(false);

        label_Employes.setFont(font3); 
        label_Employes.setText("Số Nhân Viên:");

        label_Name.setFont(font3); 
        label_Name.setText("Tên Phòng Ban:");

        textField_Employes.setFont(font3); 
        textField_Employes.setEnabled(false);

        button_Save.setFont(font3); 
        button_Save.setText("Lưu");

        button_Cancel.setFont(font3); 
        button_Cancel.setText("Hủy Bỏ");

        button_Add.setFont(font3); 
        button_Add.setText("Thêm");

        label_MPBSearch.setFont(font3); 
        label_MPBSearch.setText("Mã Phòng Ban:");

        textField_MPBSearch.setFont(font3); 

        button_Search.setFont(font3); 
        button_Search.setText("Tìm Kiếm");

        button_SearchCancel.setFont(font3); 
        button_SearchCancel.setText("Hủy");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(label_MPB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Name, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(textField_Name, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addComponent(textField_MPB)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(label_Found)
                .addComponent(label_Employes, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(textField_Found, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addComponent(textField_Employes)).addGap(113, 113, 113))
                .addComponent(separator_Search)
            .addGroup(layout.createSequentialGroup().addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_MPBSearch).addGap(18, 18, 18)
                .addComponent(textField_MPBSearch, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE).addGap(46, 46, 46)
                .addComponent(button_Search).addGap(52, 52, 52)
                .addComponent(button_SearchCancel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                .addComponent(label_DepartmentList)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(separator_Button, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(button_Cancel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addComponent(button_Save, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)).addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(button_Add, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34)))))));
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_MPBSearch)
                .addComponent(textField_MPBSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(button_Search)
                .addComponent(button_SearchCancel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_DepartmentList, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup().addGap(47, 47, 47)
                .addComponent(button_Save, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(38, 38, 38)
                .addComponent(button_Cancel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                .addComponent(separator_Button, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE).addGap(38, 38, 38)
                .addComponent(button_Add, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(67, 67, 67)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(textField_Employes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addComponent(label_Employes)))
            .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_MPB)
                .addComponent(textField_MPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_Found)
                .addComponent(textField_Found, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_Name)
                .addComponent(textField_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))).addContainerGap(77, Short.MAX_VALUE)));
    }                        

    public void setEnable(boolean b) {
        textField_MPB.setEnabled(b);
        textField_Name.setEnabled(b);
        textField_Found.setEnabled(b);
    }
    
    public void xoaForm() {
        textField_Name.setText("");
        textField_MPB.setText("");
        textField_Found.setText("");
        textField_Employes.setText("");
    }
    
    private void DisplayPB(ArrayList<PhongBan> DSPB) {
        DefaultTableModel modelTable = new DefaultTableModel();
        table_Department.setModel(modelTable);
        modelTable.addColumn("Mã Phòng Ban");
	modelTable.addColumn("Tên Phòng Ban");
        modelTable.addColumn("Ngày Thành Lập");
        try {
            for(PhongBan PB:DSPB) {
            modelTable.addRow(
                                new Object[] {
                                        PB.getMaPB()+"",
					PB.getTenPB()+"",					
					(PB.getNgayTL().getMonth()+1)+"/"+PB.getNgayTL().getDate()+
                                                "/"+(PB.getNgayTL().getYear()+1900)});
                            }
        } catch (Exception e) {
            System.err.println("Danh sách phòng ban null - QLPB_Admin");
        }
    }
    
    public void xoaPB() {
        DefaultTableModel modelTable = (DefaultTableModel) table_Department.getModel();
        int row = table_Department.getSelectedRow();
        
        int luaChon = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa phòng ban này!",
                "Confirm", JOptionPane.ERROR_MESSAGE);
        
        if(luaChon == JOptionPane.YES_OPTION) {
            this.MPB = modelTable.getValueAt(row, 0)+"";
            for(int i = 0; i < this.dsPhongBan.getDsPB().size(); i++) {
                if(this.MPB.equals(this.dsPhongBan.getDsPB().get(i).getMaPB())) {
                    this.dsPhongBan.XoaPB(this.dsPhongBan.getDsPB().get(i));
                }
            }
            modelTable.removeRow(row);
            this.WriteFilePB();
            JOptionPane.showMessageDialog(this, 
                  "Xóa phòng ban thành công!", "Xóa Phòng Ban", 
                 JOptionPane.INFORMATION_MESSAGE);
        }    
    }
    
    public void hienThiChiTiet() {
        this.setEnable(true);
        DefaultTableModel modeltable = (DefaultTableModel) table_Department.getModel();
        int row = table_Department.getSelectedRow();
        
        String maPB = modeltable.getValueAt(row, 0)+"";
        String tenPB = modeltable.getValueAt(row, 1)+"";
        String ngayTL = modeltable.getValueAt(row,2)+"";
        
        textField_MPB.setText(maPB);
        textField_Name.setText(tenPB);
        textField_Found.setText(ngayTL);
        
        int count = 0;
        for (NhanVien NV : this.dsNhanVien.getDsNV()) {
            if(tenPB.equals(NV.getPhongBan().getTenPB()))  count++;
        }
        
        textField_Employes.setText(count+"");
        this.MPB = maPB;
    }

    public boolean themPB(PhongBan PB) {
        for (PhongBan pb : this.dsPhongBan.getDsPB()) {
            if(PB.getMaPB().equals(pb.getMaPB()))  return false;
        }
        dsPhongBan.ThemPB(PB);
        this.xoaForm();  
        this.setEnable(false);
        DisplayPB(this.dsPhongBan.getDsPB());
        this.WriteFilePB();
        JOptionPane.showMessageDialog(this, 
                "Thêm phòng ban thành công!", "Thêm Phòng Ban", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public boolean capNhatPB(PhongBan PB) {
        for (PhongBan pb : this.dsPhongBan.getDsPB()) {
            if(PB.getMaPB().equals(pb.getMaPB()) && !PB.getMaPB().equals(this.MPB))  
                return false;
        }
        this.dsPhongBan.CapNhatPB(this.MPB, PB);
        DisplayPB(this.dsPhongBan.getDsPB());
        this.xoaForm();     
        this.setEnable(false);
        this.WriteFilePB();
        JOptionPane.showMessageDialog(this, 
                "Cập nhật thông tin phòng ban thành công!", "Cập Nhật Thông Tin", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public void timKiemPB() {
        DisplayPB(this.dsPhongBan.getDsPB());
        DefaultTableModel modelTable = (DefaultTableModel) table_Department.getModel();
        int countRow = modelTable.getRowCount();
        String maPB = this.textField_MPBSearch.getText();
        ArrayList<String> idCanXoa = new ArrayList<>();
        
        if(maPB.length() > 0) {
            for(int i = 0; i < countRow; i++) {
                String id = modelTable.getValueAt(i, 0)+"";
                if(!id.equals(maPB)) {
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
        this.textField_MPBSearch.setText("");
        DisplayPB(this.dsPhongBan.getDsPB());
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
            System.err.println("Không tìm thấy file Phòng Ban - QLPB_Admin");
        }
        this.dsPhongBan.setDsPB(phongBan);
    }
    
    private void WriteFilePB() {
         try {          
            FileOutputStream fos = new FileOutputStream("phongban.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(PhongBan pb:this.dsPhongBan.getDsPB()) {
                oos.writeObject(pb);
            }
            oos.close();
        } catch (IOException e) {
             System.err.println("Không tìm thấy file Phong Ban - QLPB_Admin");
        }
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
            System.err.println("Lỗi đọc file Nhân Viên - QLPB_Admin");
        }
        this.dsNhanVien.setDsNV(nhanVien);       
    }

}
