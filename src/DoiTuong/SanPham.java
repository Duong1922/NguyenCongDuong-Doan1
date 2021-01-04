package DoiTuong;

import java.util.concurrent.atomic.AtomicInteger;

public class SanPham {
    private String id;
   private String TenSP;
   private int imei;
   private String dungluong;
   private String mau;
   private int gia;
   private int soLuong;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public String getDungluong() {
        return dungluong;
    }

    public void setDungluong(String dungluong) {
        this.dungluong = dungluong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }
    public int getgia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


    public SanPham(String id, String tenSP, int imei, String dungluong, String mau, int gia, int soLuong) {
        this.id = id;
        TenSP = tenSP;
        this.imei = imei;
        this.dungluong = dungluong;
        this.mau = mau;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return  id + "-" + TenSP + "-"  + imei + "-" + dungluong  + "-" + mau +"-" +gia+"-"+soLuong  ;
    }
}
