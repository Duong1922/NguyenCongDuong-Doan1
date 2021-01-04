package com.model;

import DoiTuong.SanPham;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanliSanPham {
    static String path = "E:/duong/SanPham.txt";
    static ArrayList<SanPham> List = new ArrayList();
    static Scanner scr = new Scanner(System.in);
    private String id;
    private String TenSP;
    private int imei;
    private String dungluong;
    private String mau;
    private int gia;

    public static void main(String[] args) {
        menuSP();
    }

    public static void menuSP() {
        QuanliSanPham qlsp = new QuanliSanPham();

        do {

            System.out.println("-------------MENU-QUẢN-LÝ-SẢN-PHẨM-------------");
            System.out.println("1. Xem danh sách sản phẩm.                     ");
            System.out.println("2. Sửa sản phẩm có mã nhập vào từ bàn phím.");
            System.out.println("3. Tìm kiếm sản phẩm có mã nhập vào từ bàn phím.");
            System.out.println("4. Tìm kiếm sản phẩm có tên nhập vào từ bàn phím.");
            System.out.println("5. Xóa sản phẩm có mã nhập vào từ bàn phím.    ");
            System.out.println("0. Thoát.                                       ");
            System.out.println("------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            Scanner nhap = new Scanner(System.in);
            int c = nhap.nextInt();
            switch (c) {
                case 1:
                    qlsp.hienthi();
                    break;
                case 2:
                    qlsp.update();
                    break;
                case 3:
                    qlsp.timkiem();
                    break;
                case 4:
                    qlsp.timkiemtheoten();
                    break;
                case 5:
                    qlsp.delete();
                case 0:
                    System.exit(c);
                    break;
            }
            if (c == 0) {
                break;
            }
        } while (true);
    }



    private void hienthi() {
        List.clear();
        QuanliSanPham ql = new QuanliSanPham();
        ql.doc();
        System.out.printf("|-%-10s---%-15s---%-20s---%-20s---%-15s---%-15s---%-15s-|\n", "----------", "---------------", "--------------------", "--------------------", "---------------", "---------------","---------------");
        System.out.printf("| %-10s | %-15s | %-20s | %-20s | %-15s | %-15s | %-15s |\n", "Id", "Tên sp", "Imei", "Dung lương", "Màu", "Giá","Số lượng");
        System.out.printf("| %-10s | %-15s | %-20s | %-20s | %-15s | %-15s | %-15s |\n", "----------", "---------------", "--------------------", "--------------------", "---------------", "---------------","---------------");
        for (SanPham s : List) {
            System.out.printf("| %-10s | %-15s | %-20s | %-20s | %-15s | %-15s | %-15s |\n", s.getId(), s.getTenSP(), s.getImei(), s.getDungluong(), s.getMau(), s.getgia(),s.getSoLuong());
        }
        System.out.printf("|-%-10s---%-15s---%-20s---%-20s---%-15s---%-15s---%-15s-|\n", "----------", "---------------", "--------------------", "--------------------", "---------------", "---------------","---------------");
    }

    public void update() {
        int kt = 0;
        List.clear();
        QuanliSanPham ql = new QuanliSanPham();
        ql.doc();
        System.out.println("Nhập mã sản phẩm cần sửa: ");
        String idsua = scr.nextLine();
        for (int i = 0; i < List.size(); i++) {
            if (idsua.equals(List.get(i).getId() + "")) {
                kt = 1;
                System.out.println("Nhập tên sản phẩm:  ");
                TenSP = scr.nextLine();
                System.out.println("Nhập imei  " + TenSP + ":");
                imei = Integer.parseInt(scr.nextLine());
                System.out.println("Nhập dung lượng" + TenSP + ":");
                dungluong = scr.nextLine();
                System.out.println("Nhập màu điện thoại :");
                mau = scr.nextLine();
                SanPham sanPham = new SanPham(idsua, TenSP, imei, dungluong, mau, List.get(i).getGia(), List.get(i).getSoLuong());
                List.set(i, sanPham);
                ql.ghi(List);
            }
        }
        if (kt == 0) {
            System.out.println("Không tìm thấy sản phẩm nào có mã " + id);
        }
    }

    public void delete() {
        int kt = 0;
        List.clear();
        QuanliSanPham ql = new QuanliSanPham();
        ql.doc();
        System.out.println("Nhập mã sản phẩm cần xoá: ");
        String idxoa = scr.nextLine();
        for (int i = 0; i < List.size(); i++) {
            if (idxoa.equals(List.get(i).getId())) {
                kt = 1;
                List.remove(List.get(i));
                ql.ghi(List);
                System.out.println("ĐÃ XÓA THÀNH CỒNG SẢN PHẨM CÓ MÃ " + idxoa);
            }
        }
        if (kt == 0) {
            System.out.println("không tìm thấy mã sản phẩm ");
        }
    }

    public void timkiem() {
        List.clear();
        QuanliSanPham ql = new QuanliSanPham();
        ql.doc();
        System.out.println("Nhập mã sản phẩm cần tìm kiếm:");
        String idtimkiem = scr.nextLine();
        int kt = 0;
        System.out.printf("|-%-10s---%-15s---%-15s---%-20s---%-20s---%-15s-|\n","----------","---------------","---------------","--------------------","--------------------","---------------");
        System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-20s | %-15s |\n", "Id", "Tên sp", "Imei", "Dung lượng", "Màu", "Giá");
        for (SanPham s : List) {
            if (idtimkiem.equals(s.getId() + "")) {
                kt = 1;
                System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-20s | %-15s |\n", s.getId(), s.getTenSP(), s.getImei(), s.getDungluong(), s.getMau(), s.getgia());
            }
            }
        System.out.printf("|-%-10s---%-15s---%-15s---%-20s---%-20s---%-15s-|\n","----------","---------------","---------------","--------------------","--------------------","---------------");
        if (kt == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public void timkiemtheoten() {
        List.clear();
        QuanliSanPham ql = new QuanliSanPham();
        ql.doc();
        System.out.println("Nhập mã sản phẩm cần tìm kiếm:");
        String tentimkiem = scr.nextLine();
        int kt = 0;
        System.out.printf("|-%-10s---%-15s---%-15s---%-20s---%-20s---%-15s-|\n","----------","---------------","---------------","--------------------","--------------------","---------------");
        System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-20s | %-15s |\n", "Id", "Tên sp", "Imei", "Dung lượng", "Màu", "Giá");
        System.out.printf("|-%-10s---%-15s---%-15s---%-20s---%-20s---%-15s-|\n","----------","---------------","---------------","--------------------","--------------------","---------------");
        for (SanPham s : List) {

            if (tentimkiem.equalsIgnoreCase(s.getTenSP() + ""))

                System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-20s | %-15s |\n", s.getId(), s.getTenSP(), s.getImei(), s.getDungluong(), s.getMau(), s.getgia());
        }
        System.out.printf("|-%-10s---%-15s---%-15s---%-20s---%-20s---%-15s-|\n","----------","---------------","---------------","--------------------","--------------------","---------------");
        if (kt == 0) {
        }
    }

    public void ghi(ArrayList list) {
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
                SanPham sp1 = new SanPham(s[0], s[1], Integer.parseInt(s[2]), s[3], s[4], Integer.parseInt(s[5]), Integer.parseInt(s[6]));
                List.add(sp1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi " + ex);
        } catch (IOException ex) {
            System.out.println("Xảy ra lỗi" + ex);
        }
    }
}
