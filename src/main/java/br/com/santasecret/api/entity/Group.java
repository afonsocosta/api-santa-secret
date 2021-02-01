package br.com.santasecret.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(schema = "santa_secret", name = "group_tb")
@Data
public class Group implements Serializable {

    private static final long serialVersionUID = -1685998475186673891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_user_id", updatable = false)
    private User owner;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

}
