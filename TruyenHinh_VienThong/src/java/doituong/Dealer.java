package doituong;

public class Dealer {

    private int id;
    
    private String username;

    private String password;

    private String name;

    private String cardId;

    private String phoneNumber;

    private String email;

    private String address;

    private int packageId;

    private int dealerId;

    public Dealer() {
    }

    public Dealer(int id, String username, String password, String name, String cardId,
            String phoneNumber, String email, String address, int packageId,
            int dealerId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.packageId = packageId;
        this.dealerId = dealerId;
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

}
