package com.model;

import DoiTuong.Donhang;
import DoiTuong.SanPham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quanlidonhang {
    static String path = "E:/duong/quanlidonhang.txt";
    static ArrayList<Donhang> list = new ArrayList();
    static Scanner scr = new Scanner(System.in);
    private String id;
    private String sdt;
    private String hoten;
    private String diachi;
    private String Ngaymua;
    private String Ngayhetbaohanh;
    private int gia;
    private int soluong;
    private int thanhtien;

    public static void main(String[] args) {
        menudh();
    }
    public static void menudh() {   Quanlidonhang qldh = new Quanlidonhang();
        do {

            System.out.println("-----------MENU-QUẢN-LÝ-ĐƠN-HÀNG-------------");
            System.out.println("1. Thêm một đơn hàng mới.                      ");
            System.out.println("2. Xem danh sách đơn hàng.                     ");
            System.out.println("3. Sửa  đơn hàng có mã nhập từ bàn phím.");
            System.out.println("4. Tìm kiếm đơn hàng có mã nhập từ bàn phím.");
            System.out.println("0. Thoát.                                       ");
            System.out.println("------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            Scanner nhap = new Scanner(System.in);
            int c = nhap.nextInt();
            switch (c) {
                case 1:
                    qldh.themdonhang();
                    break;
                case 2:
                    qldh.hienthi();
                    break;
                case 3:
                    qldh.update();
                    break;
                case 4:
                    qldh.timkiem();
                    break;
                case 0:
                    System.exit(c);
                    break;
            }
            if (c == 0) {
                break;
            }
        } while (true);
    }
    public void themdonhang() {
        Quanlidonhang ql = new Quanlidonhang();
        list.clear();
        ql.doc(); // đọc dữ liệu sản phẩm --> trong list là sẽ có dữ liệu của sản phảm
        System.out.print("Nhập mã đơn hàng:");
        id = scr.nextLine();
        System.out.println("Nhập họ tên:");
        hoten = scr.nextLine();
        do {
            System.out.println("Nhập số điện thoại:");
            sdt = scr.nextLine();
        } while (!checkPhone(sdt));
        String masp="";
        do{
            System.out.println("Nhập mã sản phẩm:");
             masp = scr.nextLine();
        }while (timkiemSP(masp)==0);
        System.out.println("Nhập địa chỉ:");
        diachi = scr.nextLine();
        System.out.println("Nhập ngày mua:");
        Ngaymua = scr.nextLine();
        System.out.println("Nhập ngày hết bảo hành:");
        Ngayhetbaohanh = scr.nextLine();
        System.out.println("Giá bán:");
        gia = Integer.parseInt(scr.nextLine());
        System.out.println("Nhập số lượng:");
        soluong = Integer.parseInt(scr.nextLine());
        thanhtien = soluong*gia;
        countDownProduct(masp);
        // nhập thông tin cho don hang
//        String id, String hoten, String diachi, String sdt, String ngaymua,String ngayhetbaohanh,String gia
        list.add(new Donhang(id,masp, hoten, diachi, sdt, Ngaymua, Ngayhetbaohanh, gia,soluong,thanhtien)); // đưa thông tin vào trong mảng đơn hàng
        ql.ghi(list,path); // lưu lại danh sách đơn hàng
    }
    static String pathSP = "E:/duong/SanPham.txt";
    private void countDownProduct(String masp) {
        ArrayList<SanPham> list = docSP();
        if(list.size()>0){
            for(SanPham sp : list){
                if(sp.getId().equals(masp)){
                    sp.setSoLuong(sp.getSoLuong()-1);
                }
            }
            ghi(list,pathSP);
        }
    }
    public boolean checkPhone(String phoneStr) {
        char first = phoneStr.charAt(0);
        if (phoneStr.length() == 10 && first == '0') {
            return true;
        }
        return false;
    }
    public void hienthi() {
        list.clear();
        Quanlidonhang qldh = new Quanlidonhang();
        QuanliSanPham qlsp = new QuanliSanPham();
        qldh.doc();
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-15s %-10s %-15s %-10s %-5s\n", "Id", "Họ tên","SDT","Địa chỉ","Tên máy","Imei","Màu","Dung lượng","Giá","Số lượng");
        for (Donhang s : list) {
            ArrayList<SanPham> listsp = docSP();
            for(SanPham sp : listsp){
                if(sp.getId().equals(s.getMaSp())){
                    System.out.printf("%-10s %-20s %-15s %-15s %-15s %-15s %-10s %-15s %-10s %-5s\n", s.getId(),s.getHoten(),s.getSdt(),s.getDiachi(), sp.getTenSP(),sp.getImei(),sp.getMau(),sp.getDungluong(), s.getGia(),s.getSoluong());
                    System.out.printf("Ngày mua: %-150s\nNgày hết hạn bảo hành: %-150s\nThành tiền: %-150s\n",s.getNgaymua(),s.getNgayhetbaohanh(),s.getThanhtien());
                }
            }
        }
    }

    public void update() {
        int kt = 0;
        list.clear();
        Quanlidonhang ql = new Quanlidonhang();
        ql.doc();
        System.out.println("Nhập mã đơn hàng cần sửa: ");
        String idsua = scr.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (idsua.equalsIgnoreCase(list.get(i).getId())) {
                kt = 1;
                System.out.println("Nhập số điện thoại:");
                sdt = scr.nextLine();
                System.out.println("Nhập họ tên: ");
                hoten = scr.nextLine();
                System.out.println("Nhập địa chỉ: ");
                diachi = scr.nextLine();
                System.out.println("Nhập ngày mua : ");
                Ngaymua = scr.nextLine();
                System.out.println("Nhập ngày hết hạn bảo hành :");
                Ngayhetbaohanh = scr.nextLine();
                System.out.println(" Nhập giá bán: ");
                gia = Integer.parseInt(scr.nextLine());
                System.out.println("Nhập số lượng: ");
                soluong = Integer.parseInt(scr.nextLine());
                Donhang donhang = new Donhang(idsua,list.get(i).getMaSp(), sdt, hoten, diachi, Ngaymua, Ngayhetbaohanh, gia,soluong,thanhtien);
                list.set(i, donhang);
                ql.ghi(list,path);
            }
        }
        if (kt == 0) {
            System.out.println("Không tìm thấy đơn hàng nào có mã" + idsua);
        }
    }

    public int timkiemSP(String idsp) {
        ArrayList<SanPham> list = docSP();
        int kt = 0;
        System.out.printf("%-10s %-15s %-15s %-20s %-20s %-20s \n", "Id", "Tên sp", "Imei", "Dung lượng", "Màu", "Giá");
        for (SanPham s : list) {
            String idhihi = s.getId();
            if (idsp.equals((idhihi)+"")){
                kt=1;
                System.out.printf("%-10s %-15s %-15s %-20s %-20s %-20s\n", s.getId(), s.getTenSP(), s.getImei(), s.getDungluong(), s.getMau(), s.getgia());
            }
        }
        if (kt == 0) {
            System.out.println("Không tìm thấy thông tin sản phẩm");
        }
        return kt;
    }

    public void timkiem() {
        list.clear();
        doc();
        System.out.println("Nhập mã đơn hàng cần tìm kiếm:");
        String idtimkiem = scr.nextLine();
        int kt = 0;
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-15s %-10s %-15s %-10s %-5s\n", "Id", "Họ tên","SDT","Địa chỉ","Tên máy","Imei","Màu","Dung lượng","Giá","Số lượng");
        for (Donhang s : list) {
            ArrayList<SanPham> listsp = docSP();
            if(s.getId().equals(idtimkiem)){
                for(SanPham sp : listsp){
                    if(sp.getId().equals(s.getMaSp())){
                        kt=1;
                        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-15s %-10s %-15s %-10s %-5s\n", s.getId(),s.getHoten(),s.getSdt(),s.getDiachi(), sp.getTenSP(),sp.getImei(),sp.getMau(),sp.getDungluong(), s.getGia(),s.getSoluong());
                        System.out.printf("Ngày mua: %-150s\nNgày hết hạn bảo hành: %-150s\nThành tiền: %-150s\n",s.getNgaymua(),s.getNgayhetbaohanh(),s.getThanhtien());
                        break;
                    }
                }
            }
        }


        if (kt == 0) {
            System.out.println("Không tìm thấy");
        }

    }
    public void ghi(ArrayList list,String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter w = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                w.write(list.get(i).toString());
                w.newLine();
            }
            w.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void doc() {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("-"); // bỏ đi các dấu gạch
                Donhang dh1 = new Donhang(s[0],s[1],s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]),Integer.parseInt(s[8]),Integer.parseInt(s[9]));
                list.add(dh1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("có lỗi " + ex);
        } catch (IOException ex) {
            System.out.println("xảy ra lỗi" + ex);
        }
    }
    public ArrayList<SanPham> docSP() {
        ArrayList<SanPham> listsp = new ArrayList<>();
        try {
            File file = new File(pathSP);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("-"); // bỏ đi các dấu gạch
                SanPham sp1 = new SanPham(s[0], s[1], Integer.parseInt(s[2]),s[3],s[4],Integer.parseInt(s[5]),Integer.parseInt(s[6]));
                listsp.add(sp1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi " + ex);
        } catch (IOException ex) {
            System.out.println("Xảy ra lỗi" + ex);
        }
        return listsp;
    }
}

