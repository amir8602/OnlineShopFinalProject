package ir.sae.onlineshop.models.user;


import ir.sae.onlineshop.models.Audit;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "User")
public class UserEntity extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name cannot be null")
    @Size(max = 20)
    @Column(name = "fName")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(max = 20)
    @Column(name = "lName")
    private String lastName;
    @NotNull(message = "nationalCode cannot be null")
    @Size(min = 3, max = 10)
    @Column(name = "nCode")
    private String nationalCode;
    @NotNull(message = "birthdate cannot be null")
    @Column(name = "birthDate")
    private Date birthDate;


    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NotNull(message = "phoneNumber cannot be null")
    @Size(max = 8)
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name ="status", nullable = false)
    private UserStatus status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;


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
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
