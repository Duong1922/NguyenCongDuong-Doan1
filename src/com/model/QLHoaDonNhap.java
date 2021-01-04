package com.model;

import DoiTuong.ChiTietHoaDonNhap;
import DoiTuong.HoaDonNhap;
import DoiTuong.SanPham;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QLHoaDonNhap {
    static String path = "E:/duong/hoaDonNhap.txt";
    static String pathCTHD = "E:/duong/ChiTietHoaDonNhap.txt";
    static String pathSP = "E:/duong/SanPham.txt";
    static ArrayList<HoaDonNhap> listHoaDonNhap = new ArrayList();
    static ArrayList<ChiTietHoaDonNhap> listCTHD = new ArrayList();
    static Scanner scr = new Scanner(System.in);


    public void themHoaDonNhap(ArrayList<HoaDonNhap> hoaDonNhaps) {
//        String MHD, String nhacungcap, String ngaynhap)
        System.out.println("Nhập mã hoá đơn:");
        String MHD = scr.nextLine();
        System.out.println("Nhập nhà cung cấp:");
        String nhaccungcap = scr.nextLine();
        System.out.println("Nhập ngày nhập DD/MM/YY:");
        String ngaynhap = scr.nextLine();
        hoaDonNhaps.add(new HoaDonNhap(MHD, nhaccungcap, ngaynhap));
    }

    public void themChitiethoadon(ArrayList<ChiTietHoaDonNhap> chiTietHoaDonNhaps, ArrayList<HoaDonNhap> hoaDonNhaps) {
        System.out.println("Nhập mã hoá đơn:");
        String MHD = scr.nextLine();
        //String maHoaDon, String tenMay, String mau, String dungluong, int soLuong, int gia, int thanhtien) {
        boolean kt = false;
        for (HoaDonNhap hoaDonNhap : hoaDonNhaps
        ) {
            if (MHD.equals(hoaDonNhap.getMHD())) {
                kt = true;

                System.out.println("Nhập tên máy :");
                String tenMay = scr.nextLine();
                System.out.println("Nhập màu " + tenMay +":");
                String mau = scr.nextLine();
                System.out.println("Nhập dung lượng " + tenMay+":");
                String dungluong = scr.nextLine();
                System.out.println("Nhập số lượng :");
                int soluong = scr.nextInt();
                System.out.println("Nhập giá :" );
                int gia = scr.nextInt();
                scr.nextLine();
                int thanhtien = soluong * gia;
                ArrayList<SanPham> listSp = docSP();
                for(int i=0;i<soluong;i++){
                    System.out.println("Nhập id của sản phẩm thứ "+(i+1));
                    String idsp = scr.nextLine();
                    SanPham sp =new SanPham(idsp,tenMay,0,dungluong,mau,gia,1);
                    listSp.add(sp);
                }
                ghi(listSp,pathSP);
                chiTietHoaDonNhaps.add(new ChiTietHoaDonNhap(MHD, tenMay, mau,dungluong,soluong,gia,thanhtien));
            }
            QLHoaDonNhap ql =new QLHoaDonNhap();
            ql.ghi(listHoaDonNhap,path);
            ql.ghi(listCTHD,pathCTHD);
        }
        if (kt == false) System.out.println("Nhập sai mã .Mời nhập lại");
    }



    public void hienthi(ArrayList<ChiTietHoaDonNhap> chiTietHoaDonNhaps, ArrayList<HoaDonNhap> hoaDonNhaps) {
        System.out.printf("|-%-10s--%-20s--%-20s--%-20s--%-10s--%-15s--%-10s--%-15s--%-15s|\n","----------","--------------------","--------------------","--------------------","----------","---------------","----------","---------------","---------------");
        System.out.printf("| %-10s| %-20s| %-20s| %-20s| %-10s| %-15s| %-10s| %-15s| %-15s|\n","Mã HĐ","Nhà cung cấp","Ngày nhập","Tên sản phẩm","Màu","Dung lượng","Số lượng","Giá","Thành tiền");
        System.out.printf("|-%-10s--%-20s--%-20s--%-20s--%-10s--%-15s--%-10s--%-15s--%-15s|\n","----------","--------------------","--------------------","--------------------","----------","---------------","----------","---------------","---------------");
        for (HoaDonNhap hoaDonNhap : hoaDonNhaps) {
            for (ChiTietHoaDonNhap chiTietHoaDonNhap : chiTietHoaDonNhaps) {
                if(hoaDonNhap.getMHD().equals(chiTietHoaDonNhap.getMaHoaDon())){
                    System.out.printf("| %-10s| %-20s| %-20s| %-20s| %-10s| %-15s| %-10s| %-15s| %-15s|\n",hoaDonNhap.getMHD(),hoaDonNhap.getNhacungcap(),hoaDonNhap.getNgaynhap(),chiTietHoaDonNhap.getTenMay(),chiTietHoaDonNhap.getMau(),chiTietHoaDonNhap.getDungluong(),chiTietHoaDonNhap.getSoLuong(),chiTietHoaDonNhap.getGia(),chiTietHoaDonNhap.getThanhtien());
                }
            }
        }
        System.out.printf("|-%-10s--%-20s--%-20s--%-20s--%-10s--%-15s--%-10s--%-15s--%-15s|\n","----------","--------------------","--------------------","--------------------","----------","---------------","----------","---------------","---------------");
    }

    public void searchHD() {
        QLHoaDonNhap ql = new QLHoaDonNhap();
        ArrayList<HoaDonNhap> listHDN = new ArrayList<>();
        ArrayList<ChiTietHoaDonNhap> listchitiethoadon = new ArrayList<>();
        System.out.println("Nhập mã hoá đơn:");
        String MHD = scr.nextLine();
        //String maHoaDon, String tenMay, String mau, String dungluong, int soLuong, int gia, int thanhtien) {
        boolean kt = false;
        for (HoaDonNhap HDN : listHoaDonNhap) {
            if (HDN.getMHD().equals(MHD)) {
                kt = true;
                listHDN.add(HDN);
                for (ChiTietHoaDonNhap cthd : listCTHD) {
                    if (cthd.getMaHoaDon().equals(HDN.getMHD())) {
                        listchitiethoadon.add(cthd);
                    }
                }
                hienthi(listchitiethoadon, listHDN);
            }
        }
        if (kt == false) {
            System.out.println("Không tìm thấy");
        }
    }
    public void delete(){
        QLHoaDonNhap ql = new QLHoaDonNhap();
        System.out.println("Nhập mã hoá đơn:");
        String MHD = scr.nextLine();
        //String maHoaDon, String tenMay, String mau, String dungluong, int soLuong, int gia, int thanhtien) {
        boolean kt = false;
        for(int i=0;i<listHoaDonNhap.size();i++){
            if (listHoaDonNhap.get(i).getMHD().equals(MHD)) {
                kt=true;
                listHoaDonNhap.remove(i);
                for(int j =0;j<listCTHD.size();j++){
                    if(listCTHD.get(j).getMaHoaDon().equals(MHD)){
                        listCTHD.remove(j);
                    }
                }
                ghi(listCTHD,pathCTHD);
                ghi(listHoaDonNhap,path);
                System.out.println("đã xóa");
            }
        }
        if (kt == false) {
            System.out.println("Không tìm thấy hoá đơn nào có mã "+MHD);
        }
    }
    public static void main(String[] args) {
        menuHoaDonNhap();
    }
    public static void menuHoaDonNhap(){
        QLHoaDonNhap ql = new QLHoaDonNhap();
        ql.doc();
        ql.docCTHD();
        do {
            System.out.println("------------MENU-QUẢN-LÝ-HOÁ-ĐƠN-NHẬP-------------");
            System.out.println("1. Thêm hoá đơn mới.                             ");
            System.out.println("2. Thêm chi tiết hoá đơn nhập                    ");
            System.out.println("3. Tìm kiếm hoá đơn có mã nhập từ bàn phím       ");
            System.out.println("4. Hiển thị danh sách hoá đơn                    ");
            System.out.println("5. Xoá hoá đơn                                   ");
            System.out.println("0. Thoát.                                        ");
            System.out.println("-------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            Scanner nhap = new Scanner(System.in);
            int c = nhap.nextInt();
            switch (c) {
                case 1:
                    ql.themHoaDonNhap(listHoaDonNhap);
                    break;
                case 2:
                    ql.themChitiethoadon(listCTHD,listHoaDonNhap);
                    break;
                case 3:
                    ql.searchHD();
                    break;
                case 4:
                    ql.hienthi(listCTHD,listHoaDonNhap);
                    break;
                case 5:
                    ql.delete();
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

    public void ghi(ArrayList list,String pathHihi) {
        try {
            File file = new File(pathHihi);
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

    public void doc() {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("-"); // bỏ đi các dấu gạch
                HoaDonNhap sp1 = new HoaDonNhap(s[0],s[1],s[2]);
                listHoaDonNhap.add(sp1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi " + ex);
        } catch (IOException ex) {
            System.out.println("Xảy ra lỗi" + ex);
        }
    }

    public void docCTHD() {
        try {
            File file = new File(pathCTHD);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("-"); // bỏ đi các dấu gạch
                ChiTietHoaDonNhap sp1 = new ChiTietHoaDonNhap(s[0],s[1],s[2],s[3],Integer.parseInt(s[4]),Integer.parseInt(s[5]),Integer.parseInt(s[6]));
                listCTHD.add(sp1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi " + ex);
        } catch (IOException ex) {
            System.out.println("Xảy ra lỗi" + ex);
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


