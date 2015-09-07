
package doituong;

import java.sql.Date;

public class Order {
    private int id;
    
    private String username;
    
    private String hinhThucThanhToan;
    
    private String tenDichVu;
    
    private String mien;
    
    private String diaChiNapDat;
    
    private int thoiLuong;
    
    private String gia;
    
    private String status;

    private Date dateRegister;

    private Date dateBegin;

    private Date dateEnd;
    
    public int getId() {
        return id;
    }

    public Order() {
    }

    public Order(String username, String tenDichVu, String mien, String status) {
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
    }

    public Order(int id, String username, String tenDichVu, String mien, String status) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
    }
    public Order(int id, String username, String tenDichVu, String mien, String status, Date dateEnd, String a) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
        this.dateEnd = dateEnd;
    }
    public Order(int id, String username, String tenDichVu, String mien, String status, Date dateEnd, String a, String hinhThucThanhToan, String diaChiNapDat, int thoiLuong, String gia, Date dateRegister) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
        this.dateEnd = dateEnd;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.diaChiNapDat = diaChiNapDat;
        this.thoiLuong = thoiLuong;
        this.gia = gia;
        this.dateRegister = dateRegister;
    }
    
    public Order(int id, String username, String tenDichVu, String mien, String status, Date dateRegister) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
        this.dateRegister = dateRegister;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
    
    public Order(int id, String username, String tenDichVu, String mien, String status, Date dateRegister, Date dateBegin, Date dateEnd) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.status = status;
        this.dateRegister = dateRegister;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
    
    public Order(int id, String username, String tenDichVu, String mien, String diaChiNapDat, int thoiLuong, String gia, String status, Date dateRegister, Date dateBegin, Date dateEnd) {
        this.id = id;
        this.username = username;
        this.tenDichVu = tenDichVu;
        this.mien = mien;
        this.diaChiNapDat = diaChiNapDat;
        this.thoiLuong = thoiLuong;
        this.gia = gia;
        this.status = status;
        this.dateRegister = dateRegister;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMien() {
        return mien;
    }

    public void setMien(String mien) {
        this.mien = mien;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDiaChiNapDat() {
        return diaChiNapDat;
    }

    public void setDiaChiNapDat(String diaChiNapDat) {
        this.diaChiNapDat = diaChiNapDat;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

  public String getHinhThucThanhToan() {
    return hinhThucThanhToan;
  }

  public void setHinhThucThanhToan(String hinhThucThanhToan) {
    this.hinhThucThanhToan = hinhThucThanhToan;
  }
    
}
