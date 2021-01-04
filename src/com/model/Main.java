package com.model;

import DoiTuong.Donhang;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        do {
            System.out.println(".----------------------------------------------------.");
            System.out.println("|        QUẢN LÝ CỬA HÀNG ĐIỆN THOẠI XUÂN NAM        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|               1.QUẢN LÝ SẢN PHẨM                   |");
            System.out.println("|               2.QUẢN LÝ ĐƠN HÀNG                   |");
            System.out.println("|               3.QUẢN LÝ HOÁ ĐƠN NHẬP               |");
            System.out.println("|               4.QUẢN LÝ DOANH THU                  |");
            System.out.println("|               0.Thoát                              |");
            System.out.println(".----------------------------------------------------.");
            Scanner nhap = new Scanner(System.in);
            System.out.println("Nhập lựa chọn :");
            int c = nhap.nextInt();
            switch (c) {
                case 1:
                    QuanliSanPham.menuSP();
                    break;
                case 2:
                    Quanlidonhang.menudh();
                    break;
                case 3:
                    QLHoaDonNhap.menuHoaDonNhap();
                    break;
                case 4:
                   QlDoanhThu.xuatDoanhthu();
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
	// write your code here

}
