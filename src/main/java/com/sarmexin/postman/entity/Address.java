package com.sarmexin.postman.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;

    private String city;

    private String street;

    private String house;

    private int entrance;

    private int flat;

}
