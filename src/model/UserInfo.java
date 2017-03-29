package model;

/**
 * Created by Khanh Nguyen on 27/03/2017.
 */
public class UserInfo {
    private String fullName;
    private String birthday;
    private String address;
    private String hobie;
    private String description;
    private String phone;
    private Account account;

    public UserInfo() {
    }

    public UserInfo(String fullName, String birthday, String address, String hobie, String description, String phone, Account account) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.hobie = hobie;
        this.description = description;
        this.phone = phone;
        this.account = account;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobie() {
        return hobie;
    }

    public void setHobie(String hobie) {
        this.hobie = hobie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
