package fptu.sumer.foodstore_api.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel(description = "All details about the Account. ")
@Table(name = "Account", schema = "dbo", catalog = "SmartFarm")
public class AccountEntity {
    @Id
    @Column(name = "UserId")
    private String userId;
    @Basic
    @Column(name = "UserPassword")
    private String userPassword;
    @Basic
    @Column(name = "UserName")
    private String userName;
    @Basic
    @Column(name = "UserAddress")
    private String userAddress;
    @Basic
    @Column(name = "UserPhoneNo")
    private String phone;
    @Basic
    @Column(name = "UserEmail")
    private String email;

    @Basic
    @Column(name = "UserStatus")
    private int status;

    public AccountEntity() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
