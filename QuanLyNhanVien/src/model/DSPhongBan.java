/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;



public class DSPhongBan {
    private ArrayList<PhongBan> dsPB;

    public DSPhongBan(ArrayList<PhongBan> dsPB) {
        this.dsPB = dsPB;
       
    }

    public DSPhongBan() {
        this.dsPB = new ArrayList<>();
    }

    public ArrayList<PhongBan> getDsPB() {
        return dsPB;
    }

    public void setDsPB(ArrayList<PhongBan> dsPB) {
        this.dsPB = dsPB;
    }
    
    public void ThemPB(PhongBan pb) {
        dsPB.add(pb);
    }
    
    public void XoaPB(PhongBan pb) {
        dsPB.remove(pb);
    }
    
    public void CapNhatPB(String MPB, PhongBan pb) {
        for (PhongBan PB : dsPB) {
            if(MPB.equals(PB.getMaPB())) {
                PB.setMaPB(pb.getMaPB());
                PB.setTenPB(pb.getTenPB());
                PB.setNgayTL(pb.getNgayTL());
            }
        }       
    }
    
    public PhongBan TimPBBySTT(int sttPB) {
        if(sttPB >= dsPB.size()) return new PhongBan(null, "Không Có Phòng Ban", null);
        return dsPB.get(sttPB);
    }
    
    public PhongBan TimPBByName(String name) {
        for (PhongBan pb : dsPB) {
            if(name.equals(pb.getTenPB())) return pb;
        }
        return new PhongBan(null, "Không Có Phòng Ban", null);
    }
    
    public void In() {
        for (PhongBan pb : dsPB) {
            System.out.println(pb);          
        }
        System.out.println("--------------------------");
    }
    
}
