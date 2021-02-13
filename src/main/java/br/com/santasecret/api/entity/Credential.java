package br.com.santasecret.api.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Credential implements Serializable {

    private static final long serialVersionUID = -5520928200629326113L;
    private String email;

    private String password;

}
