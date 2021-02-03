package br.com.santasecret.api.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Credential {

    private String email;

    private String password;

}
