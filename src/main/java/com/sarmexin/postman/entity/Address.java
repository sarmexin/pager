package com.sarmexin.postman.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
