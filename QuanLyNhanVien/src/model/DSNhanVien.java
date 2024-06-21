/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class DSNhanVien {
    private ArrayList<NhanVien> dsNV;

    public DSNhanVien() {
        dsNV = new ArrayList<>();   
    }

    public DSNhanVien(ArrayList<NhanVien> dsNV) {
        this.dsNV = dsNV;
    }

    public ArrayList<NhanVien> getDsNV() {
        return dsNV;
    }

    public void setDsNV(ArrayList<NhanVien> dsNV) {
        this.dsNV = dsNV;
    }
    
    public void ThemNV(NhanVien nv) {
        dsNV.add(nv);
    }
    
    public void XoaNV(NhanVien nv) {
        dsNV.remove(nv);
    }
    
    public void CapNhatNV(int MNV, NhanVien nv) {
        for (NhanVien NV : dsNV) {
            if(MNV == NV.getMaNV()) {
                NV.setMaNV(nv.getMaNV());
                NV.setTenNV(nv.getTenNV());
                NV.setNgaySinh(nv.getNgaySinh());
                NV.setGioiTinh(nv.isGioiTinh());
                NV.setDiaChi(nv.getDiaChi());
                NV.setPhongBan(nv.getPhongBan());
                NV.setChucVu(nv.getChucVu());
                NV.setNgayVaoLam(nv.getNgayVaoLam());
                NV.setLuongCB(nv.getLuongCB());
            }
        }
    }
    
    public void In() {
        for (NhanVien nv : dsNV) {
            System.out.println(nv);          
        }
        System.out.println("---------------------");
    }
    
}
