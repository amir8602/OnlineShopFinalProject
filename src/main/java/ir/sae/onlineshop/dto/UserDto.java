package ir.sae.onlineshop.dto;


import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.enums.UserStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDto extends BaseDto {


    @NotBlank(message = "user.firstname.not.blank")
    @Size(min = 3, max = 20, message = "user.firstname.invalid.size")
    private String firstName;

    @NotBlank(message = "user.lastname.not.blank")
    @Size(min = 3, max = 20, message = "user.lastname.invalid.size")
    private String lastName;

    @NotBlank(message = "user.national.code.not.blank")
    @Size(min = 10, max = 10, message = "user.national.code.invalid.size")
    private String nationalCode;

    @NotNull(message = "user.birthdate.not.null")
    private Date birthDate;


    @Email(message = "user.email.invalid.format")
    @NotBlank(message = "user.email.not.blank")
    private String email;

    @NotBlank(message = "user.phone.number.not.blank")
    @Size(min = 11, max = 11, message = "user.phone.number.invalid.size")
    private String phoneNumber;

    private OrderDto orderDto;

    @NotNull
    private UserStatus status;

    @NotBlank(message = "user.user.name.not.blank")
    @Size(min = 4, max = 12, message = "user.user.name.invalid.size")
    private String username;

    private Long version;

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
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

    public OrderDto getOrderModel() {
        return orderDto;
    }

    public void setOrderModel(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public UserDto(Long id, String firstName, String lastName, String nationalCode, Date birthDate, String email, String phoneNumber, OrderDto orderDto, UserStatus status, String username) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderDto = orderDto;
        this.status = status;
        this.username = username;
    }


    public UserDto() {
    }


    public UserDto(String firstName, String lastName, String nationalCode, Date birthDate, String email, String phoneNumber, OrderDto orderDto, UserStatus status, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderDto = orderDto;
        this.status = status;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDto(String username) {
        this.username = username;
    }
}
