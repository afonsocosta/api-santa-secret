package br.com.santasecret.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Cellphone cannot be blank")
    private String cellphone;

}
