package DoiTuong;

public class Donhang {


    private String id;
    private  String maSp;
    private String hoten;
    private String diachi;
    private String sdt;
    private String ngaymua;
    private String ngayhetbaohanh;
    private int gia;
    private  int soluong;
    private  int thanhtien;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return soluong*gia;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }



    public Donhang (String id,String maSp, String hoten, String diachi, String sdt, String ngaymua, String ngayhetbaohanh, int gia, int soluong, int thanhtien) {
        this.id = id;
        this.maSp = maSp;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaymua = ngaymua;
        this.ngayhetbaohanh = ngayhetbaohanh;
        this.gia = gia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public String getNgayhetbaohanh() {
        return ngayhetbaohanh;
    }

    public void setNgayhetbaohanh(String ngayhetbaohanh) {
        this.ngayhetbaohanh = ngayhetbaohanh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


    @Override
    public String toString() {
        return id +"-"+maSp+"-" + hoten + "-" + diachi + "-" + sdt + "-" + ngaymua + "-" + ngayhetbaohanh + "-" + gia+ "-" +soluong+ "-" +thanhtien;
    }
}
