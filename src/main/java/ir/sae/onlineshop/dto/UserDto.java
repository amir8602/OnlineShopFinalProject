package ir.sae.onlineshop.dto;


import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.enums.UserStatus;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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


    @NotNull
    private UserStatus status;

    @NotBlank(message = "user.user.name.not.blank")
    @Size(min = 4, max = 12, message = "user.user.name.invalid.size")
    private String username;

}
