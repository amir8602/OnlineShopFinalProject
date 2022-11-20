package ir.sae.onlineshop.models.user;


import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.order.OrderEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity extends Audit {

    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "fName")
    private String firstName;



    @Column(name = "lName")
    private String lastName;



    @Column(name = "nCode")
    private String nationalCode;


    @Column(name = "birthDate")
    private Date birthDate;


    @Column(name = "email")
    private String email;



    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name ="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;


    @OneToOne(mappedBy = "userEntity")
    private OrderEntity orderEntity;


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

    public Long getCustomerId() {
        return id;
    }

    public void setCustomerId(Long customerId) {
        this.id = customerId;
    }
}
