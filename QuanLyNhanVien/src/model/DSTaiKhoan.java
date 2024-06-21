package model;

import java.util.ArrayList;

public class DSTaiKhoan {
    private ArrayList<TaiKhoan> dsTK;

    public DSTaiKhoan() {
        this.dsTK = new ArrayList<>();
    }

    public DSTaiKhoan(ArrayList<TaiKhoan> dsTK) {
        this.dsTK = dsTK;
    }

    public ArrayList<TaiKhoan> getDsTK() {
        return dsTK;
    }

    public void setDsTK(ArrayList<TaiKhoan> dsTK) {
        this.dsTK = dsTK;
    }
    
    public void ThemTK(TaiKhoan tk) {
        dsTK.add(tk);
    }
    
    public void XoaTK(TaiKhoan tk) {
        dsTK.remove(tk);
    }
    
    public void CapNhatTK(TaiKhoan tk) {
        for (TaiKhoan TK : dsTK) {
            if(tk.getTenTK().equals(TK.getTenTK())) {
                TK.setMatKhau(tk.getMatKhau());
                TK.setAuthority(tk.getAuthority());
                TK.setNgayTao(tk.getNgayTao());
            }
        }       
    }
    
     public void In() {
        for (TaiKhoan tk : dsTK) {
            System.out.println(tk);          
        }
        System.out.println("--------------------------");
    }
    
    
}
