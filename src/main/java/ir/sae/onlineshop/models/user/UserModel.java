package ir.sae.onlineshop.models.user;


import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.order.OrderModel;

import java.util.Date;

public class UserModel extends Audit {


    private Long id;



    private String firstName;



    private String lastName;



    private String nationalCode;


    private Date birthDate;



    private String email;

    private OrderModel orderModel;
    private String phoneNumber;

    private UserStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public UserModel(Long id, String firstName, String lastName, String nationalCode, Date birthDate, String email, OrderModel orderModel, String phoneNumber, UserStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.orderModel = orderModel;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String nationalCode, Date birthDate, String email, OrderModel orderModel, String phoneNumber, UserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.orderModel = orderModel;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
}