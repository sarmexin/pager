package com.sarmexin.postman.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private Set<Application> applications;

}
