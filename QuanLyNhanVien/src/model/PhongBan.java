/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

public class PhongBan implements Serializable{
    private String maPB;
    private String tenPB;
    private Date ngayTL;

    public PhongBan() {
    }

    public PhongBan(String maPB, String tenPB, Date ngayTL) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.ngayTL = ngayTL;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public Date getNgayTL() {
        return ngayTL;
    }

    public void setNgayTL(Date ngayTL) {
        this.ngayTL = ngayTL;
    }
    
    @Override
    public String toString() {
        return "PhongBan{" + "maPB=" + maPB + ", tenPB=" + tenPB + ", ngayTL=" + ngayTL.toString() + '}';
    }
    
}
