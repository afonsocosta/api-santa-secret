package br.com.santasecret.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CredentialDto {

    public CredentialDto() {

    }

    public CredentialDto(String email) {
        this.email = email;
    }

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

}
