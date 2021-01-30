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
@Table(schema = "santa_secret", name = "group")
@Data
public class Group implements Serializable {

    private static final long serialVersionUID = -1685998475186673891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private User owner;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

}
