package ir.sae.onlineshop.models.user;


import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.order.OrderEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "User")
public class UserEntity extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(max = 20)
    @Column(name = "fName")
    private String firstName;


//    @Size(max = 20)
    @Column(name = "lName")
    private String lastName;

//    @Size(min = 3, max = 10)
    @Column(name = "nCode")
    private String nationalCode;

    @Column(name = "birthDate")
    private Date birthDate;


//    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;


   @Size(max = 8)
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name ="status", nullable = false)
    private UserStatus status;

    @OneToOne(mappedBy = "userEntity")
    private OrderEntity orderEntity;

    private String username;

    public UserEntity(Long id) {
        this.id = id;
    }

    public UserEntity() {

    }

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


    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
