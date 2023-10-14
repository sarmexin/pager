package com.sarmexin.postman.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Table
@Data
public class MessageData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private long authorId;

    private long recipientId;
}
