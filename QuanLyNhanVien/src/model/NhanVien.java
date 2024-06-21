package model;

import java.io.Serializable;
import java.util.Date;

public class NhanVien implements Serializable{
    private int maNV;
    private String tenNV;
    private Date ngaySinh;
    private boolean gioiTinh;
    private Tinh diaChi;
    private PhongBan phongBan;
    private String chucVu;
    private Date ngayVaoLam;
    private double luongCB;

    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, Date ngaySinh, boolean gioiTinh,
            Tinh diaChi, PhongBan phongBan, String chucVu, Date ngayVaoLam, double luongCB) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.luongCB = luongCB;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Tinh getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(Tinh diaChi) {
        this.diaChi = diaChi;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV +
                ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh +
                ", diaChi=" + diaChi + ", phongBan=" + phongBan +
                ", chucVu=" + chucVu + ", ngayVaoLam=" + ngayVaoLam + ", luongCB=" + luongCB + '}';
    }
    
    
}
