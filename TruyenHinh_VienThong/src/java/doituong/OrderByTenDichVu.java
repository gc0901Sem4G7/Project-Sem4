package doituong;

import java.util.Date;

public class OrderByTenDichVu extends DichVu {
  
  private String username;
  
  private String diaChiNapDat;
  
  private Integer thoiLuong;
  
  private String thanhTien;
  
  private String hinhThucThanhToan;
  
  private String status;
  
  private Date dateBegin;
  
  private Date dateEnd;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDiaChiNapDat() {
    return diaChiNapDat;
  }

  public void setDiaChiNapDat(String diaChiNapDat) {
    this.diaChiNapDat = diaChiNapDat;
  }

  public String getThanhTien() {
    return thanhTien;
  }

  public void setThanhTien(String thanhTien) {
    this.thanhTien = thanhTien;
  }

  public Integer getThoiLuong() {
    return thoiLuong;
  }

  public void setThoiLuong(Integer thoiLuong) {
    this.thoiLuong = thoiLuong;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getHinhThucThanhToan() {
    return hinhThucThanhToan;
  }

  public void setHinhThucThanhToan(String hinhThucThanhToan) {
    this.hinhThucThanhToan = hinhThucThanhToan;
  }
  
}
