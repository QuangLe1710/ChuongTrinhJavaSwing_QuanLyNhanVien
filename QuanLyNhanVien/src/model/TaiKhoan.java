package model;

import java.io.Serializable;
import java.util.Date;


public class TaiKhoan implements Serializable{
    private String tenTK;
    private String matKhau;
    private String Authority;
    private Date ngayTao;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String matKhau, String Authority, Date ngayTao) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.Authority = Authority;
        this.ngayTao = ngayTao;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String Authority) {
        this.Authority = Authority;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenTK=" + tenTK + ", matKhau=" + matKhau +
                ", Authority=" + Authority + ", ngayTao=" + ngayTao + '}';
    }
    
    
}
