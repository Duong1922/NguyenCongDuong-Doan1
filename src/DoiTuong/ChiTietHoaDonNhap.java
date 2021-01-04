package DoiTuong;

public class ChiTietHoaDonNhap {
    String maHoaDon;
    private String tenMay;
    String mau;
    String dungluong;
    int soLuong;
    int gia;
    int thanhtien;


    public ChiTietHoaDonNhap(String maHoaDon, String tenMay, String mau, String dungluong, int soLuong, int gia, int thanhtien) {
        this.maHoaDon = maHoaDon;
        this.tenMay = tenMay;
        this.mau = mau;
        this.dungluong = dungluong;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return maHoaDon + "-" + tenMay + "-" + mau + "-" +dungluong + "-" + soLuong+ "-" + gia+"-"+thanhtien;
    }


    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getDungluong() {
        return dungluong;
    }

    public void setDungluong(String dungluong) {
        this.dungluong = dungluong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getThanhtien() {
        return gia*soLuong;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
}


