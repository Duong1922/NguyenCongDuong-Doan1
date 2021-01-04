package com.model;

import DoiTuong.Donhang;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QlDoanhThu {
    static String pathDH = "E:/duong/quanlidonhang.txt";
    public static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static void xuatDoanhthu(){
        ArrayList<Donhang> listDH = doc();
        System.out.println("Nhập ngày bắt đầu: ");
        String startdate = scr.nextLine();
        System.out.println("Nhập ngày kết thúc: ");
        String endDate = scr.nextLine();

        getdataFromDate(startdate,endDate,listDH);
    }

    public static ArrayList<Donhang> getdataFromDate(String startDate , String endDate,ArrayList<Donhang> listdonhang){
        ArrayList<Donhang> listDH =new ArrayList<>();
        Date date1= null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            date2= new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Donhang dh : listdonhang){
            Date date3 = null;
            try {
                date3 = new SimpleDateFormat("dd/MM/yyyy").parse(dh.getNgaymua());
                if(date3.after(date1) && date3.before(date2)){
                    listDH.add(dh);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Doanhthu(listDH);
        return listDH;
    }

    public static int Doanhthu(ArrayList<Donhang> listDH) {
        int doanhthu = 0;
        for (int i = 0; i < listDH.size(); i++) {
            doanhthu += listDH.get(i).getThanhtien();
        }
        System.out.println("Doanh thu tổng là:  "+doanhthu);
        return doanhthu;
    }

    public static ArrayList<Donhang> doc() {
        ArrayList<Donhang> list = new ArrayList<>();
        try {
            File file = new File(pathDH);
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
        return list;
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
}
