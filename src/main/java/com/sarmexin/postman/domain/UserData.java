package com.sarmexin.postman.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Data
@Table
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
