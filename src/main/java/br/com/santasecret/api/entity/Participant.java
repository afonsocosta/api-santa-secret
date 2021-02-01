package br.com.santasecret.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "santa_secret", name = "participant")
@Data
public class Participant implements Serializable {

    private static final long serialVersionUID = -8374686581167983707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @Column(name = "checked")
    public boolean checked;
}
