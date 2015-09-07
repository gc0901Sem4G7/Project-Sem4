package doituong;

public class DichVu {

    private int id;

    private String tenDichVu;

    private String giaDichVu;

    private String moTa;

    private String trangThai;

    private int dealerId;

    private String mien;
    
    public DichVu() { }

    public DichVu(String tenDichVu, String giaDichVu, String moTa, int dealerId, String trangThai) {
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.moTa = moTa;
        this.dealerId = dealerId;
        this.trangThai = trangThai;
    }
    
    public DichVu(int id, String tenDichVu, String giaDichVu, String moTa, int dealerId, String trangThai) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.moTa = moTa;
        this.dealerId = dealerId;
        this.trangThai = trangThai;
    }
    public DichVu(String tenDichVu, String giaDichVu, String moTa, int dealerId, String trangThai, String mien) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.moTa = moTa;
        this.dealerId = dealerId;
        this.trangThai = trangThai;
        this.mien = mien;
    }

    public String getMien() {
        return mien;
    }

    public void setMien(String mien) {
        this.mien = mien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(String giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
