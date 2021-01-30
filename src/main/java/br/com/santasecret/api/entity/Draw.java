package br.com.santasecret.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "santa_secret", name = "draw")
@Data
public class Draw implements Serializable {

    private static final long serialVersionUID = -578555654293459671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group group;

    @ManyToOne
    @JoinColumn(name = "user_from")
    public User userFrom;

    @ManyToOne
    @JoinColumn(name = "user_to")
    public User userTo;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
