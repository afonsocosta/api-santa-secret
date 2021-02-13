package br.com.santasecret.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private CredentialDto credential;

    @NotBlank(message = "Cellphone cannot be blank")
    private String cellphone;
    

}
