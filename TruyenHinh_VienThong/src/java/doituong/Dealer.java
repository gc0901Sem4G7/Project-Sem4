package doituong;

public class Dealer {

    private int id;
    
    private String username;

    private String password;

    private String name;
    
    private String sex;

    private String email;

    private String phone;

    private String address;

    private String mien;

    public Dealer() {
    }

    public Dealer(String username, String password, String name, String sex, String email, String phone, String address, String mien) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.mien = mien;
    }
    
    public Dealer(int id, String username, String password, String name, String sex, String email, String phone, String address, String mien) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.mien = mien;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMien() {
        return mien;
    }

    public void setMien(String mien) {
        this.mien = mien;
    }

}
