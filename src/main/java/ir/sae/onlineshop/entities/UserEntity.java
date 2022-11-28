package ir.sae.onlineshop.entities;


import ir.sae.onlineshop.base.BaseEntity;
import ir.sae.onlineshop.enums.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "User")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "user.firstname.not.blank" )
    @Size(min = 3 , max = 20 , message = "user.firstname.invalid.size")
    @Column(name = "FIRST_NAME")
    private String firstName;


    @NotBlank(message = "user.lastname.not.blank" )
    @Size(min = 3 , max = 20 , message = "user.lastname.invalid.size")
    @NotEmpty
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NATIONAL_CODE")
    @NotBlank(message = "user.national.code.not.blank")
    @Size(min = 10 , max = 10 , message = "user.national.code.invalid.size")
    private String nationalCode;

    @Column(name = "BIRTH_DATE")
    @NotNull(message = "user.birthdate.not.null" )
    private Date birthDate;


    @Email(message = "user.email.invalid.format")
    @NotBlank(message = "user.email.not.blank")
    @Column(name = "EMAIL")
    private String email;


    @Column(name = "PHONE_NUMBER")
    @NotBlank(message = "user.phone.number.not.blank")
    @Size(min =11, max = 11 , message = "user.phone.number.invalid.size")
    private String phoneNumber;

    @NotNull
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToOne(mappedBy = "user")
    private OrderEntity order;

    @Column(name = "USERNAME")
    @NotBlank(message = "user.user.name.not.blank")
    @Size(min =4, max = 12 , message = "user.user.name.invalid.size")
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


    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity orderEntity) {
        this.order = orderEntity;
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

    public UserEntity(Long id, String firstName, String lastName, String nationalCode, Date birthDate, String email, String phoneNumber, UserStatus status, OrderEntity order, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.order = order;
        this.username = username;
    }


}
