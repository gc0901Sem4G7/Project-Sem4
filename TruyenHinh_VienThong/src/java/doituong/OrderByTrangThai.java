package doituong;

import java.util.Date;

public class OrderByTrangThai {
  private Integer id;
  
  private String username;
  
  private String tenDichVu;
  
  private String dateRegister;
  
  private String dateEnd;
  
  private String email;

  public OrderByTrangThai(int id, String username, String tenDichVu, String dateRegister, String dateEnd, String email) {
    this.id = id;
    this.username = username;
    this.tenDichVu = tenDichVu;
    this.dateRegister = dateRegister;
    this.dateEnd = dateEnd;
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
  
  public String getDateRegister() {
    return dateRegister;
  }

  public void setDateRegister(String dateRegister) {
    this.dateRegister = dateRegister;
  }

  public String getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
  
}
