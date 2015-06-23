package doituong;

public class LienHe {
    private int id;
    
    private String diaChi;
    
    private String dienThoai;
    
    private String tenCongTy;
    
    private String email;
    
    private String skype;

    public LienHe() {
    }

    public LienHe(int id, String diaChi, String dienThoai, String tenCongTy, String email, String skype) {
        this.id = id;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.tenCongTy = tenCongTy;
        this.email = email;
        this.skype = skype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
    
}
