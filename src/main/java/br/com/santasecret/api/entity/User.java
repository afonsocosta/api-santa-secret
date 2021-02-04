package br.com.santasecret.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "santa_secret", name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5651845976377990969L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "credential")
    private Credential credential;
    
}
