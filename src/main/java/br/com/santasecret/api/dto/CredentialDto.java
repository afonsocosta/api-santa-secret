package br.com.santasecret.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CredentialDto {

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

}
