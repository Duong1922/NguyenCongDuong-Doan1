package DoiTuong;

public class HoaDonNhap {
    private String MHD;
    private String Nhacungcap;
    private String Ngaynhap;

    @Override
    public String toString() {
        return MHD + "-" + Nhacungcap + "-" + Ngaynhap;
    }
    public String getMHD() {
        return MHD;
    }

    public void setMHD(String MHD) {
        this.MHD = MHD;
    }

    public String getNhacungcap() {
        return Nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        Nhacungcap = nhacungcap;
    }

    public String getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        Ngaynhap = ngaynhap;
    }

    public HoaDonNhap(String MHD, String nhacungcap, String ngaynhap) {
        this.MHD = MHD;
        Nhacungcap = nhacungcap;
        Ngaynhap = ngaynhap;
    }
}
