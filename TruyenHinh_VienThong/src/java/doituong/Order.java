
package doituong;

import java.sql.Date;

public class Order {
    private int id;
    
    private String username;
    
    private String tenDichVu;
    
    private String mien;
    
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
    
}
