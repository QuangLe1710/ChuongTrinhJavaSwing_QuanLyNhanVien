/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tinh implements Serializable{ 
    private int maTinh;
    private String tenTinh;

    public Tinh() {
    }

    public Tinh(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    @Override
    public String toString() {
        return "Tinh{" + "maTinh=" + maTinh + ", tenTinh=" + tenTinh + '}';
    }
    
    public  static ArrayList<Tinh> getDSTinh() {
        String[] arrTinh = {"An Giang",
                            "Bà Rịa-Vũng Tàu",
                            "Bắc Giang",
                            "Bắc Kạn",
                            "Bạc Liêu",
                            "Bắc Ninh",
                            "Bến Tre",
                            "Bình Định",
                            "Bình Dương",
                            "Bình Phước",
                            "Bình Thuận",
                            "Cà Mau",
                            "Cần Thơ",
                            "Cao Bằng",
                            "Đà Nẵng",
                            "Đắk Lắk",
                            "Đắk Nông",
                            "Điện Biên",
                            "Đồng Nai",
                            "Đồng Tháp",
                            "Gia Lai",
                            "Hà Giang",
                            "Hà Nam",
                            "Hà Nội",
                            "Hà Tĩnh",
                            "Hải Dương",
                            "Hải Phòng",
                            "Hậu Giang",
                            "TP. Hồ Chí Minh",
                            "Hòa Bình",
                            "Hưng Yên",
                            "Khánh Hòa",
                            "Kiên Giang",
                            "Kon Tum",
                            "Lai Châu",
                            "Lâm Đồng",
                            "Lạng Sơn",
                            "Lào Cai",
                            "Long An",
                            "Nam Định",
                            "Nghệ An",
                            "Ninh Bình",
                            "Ninh Thuận",
                            "Phú Thọ",
                            "Phú Yên",
                            "Quảng Bình",
                            "Quảng Nam",
                            "Quảng Ngãi",
                            "Quảng Ninh",
                            "Quảng Trị",
                            "Sóc Trăng",
                            "Sơn La",
                            "Tây Ninh",
                            "Thái Bình",
                            "Thái Nguyên",
                            "Thanh Hóa",
                            "Thừa Thiên - Huế",
                            "Tiền Giang",
                            "Trà Vinh",
                            "Tuyên Quang",
                            "Vĩnh Long",
                            "Vĩnh Phúc",
                            "Yên Bái"};   
        ArrayList<Tinh> dsTinh = new ArrayList<>();
        int i = 0;
        for (String tenTinh : arrTinh) {
            Tinh t = new Tinh(i, tenTinh);
            i++;
            dsTinh.add(t);
        }
        return dsTinh;
    }
    
    public static Tinh getTinhByID(int queQuan) {
        return Tinh.getDSTinh().get(queQuan);
    }
    
    public static Tinh getTinhByName(String name) {
        for (Tinh t : Tinh.getDSTinh()) {
            if(name.equals(t.getTenTinh()))  return t;
        }
        return null;
    }
}
