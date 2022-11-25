package ir.sae.onlineshop.entities;

import ir.sae.onlineshop.enums.UserStatus;

import java.util.Date;

public class UserBuilder {


    Long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private UserStatus status;
    private String username;


    public UserBuilder(Long id, String firstName, String lastName, String nationalCode, Date birthDate, String email, String phoneNumber, UserStatus status, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.username = username;
    }


    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public UserBuilder setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder setStatus(UserStatus status) {
        this.status = status;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }


    public static UserBuilder newInstance()
    {
        return new UserBuilder();
    }
    public UserBuilder() {

    }
    public UserEntity build()
    {
        return new UserEntity(this.toString());
    }


}
