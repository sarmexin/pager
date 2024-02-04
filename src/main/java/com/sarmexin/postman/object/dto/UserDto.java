package com.sarmexin.postman.object.dto;

import com.sarmexin.postman.object.entity.Mail;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private long id;

    private List<Mail> mails;

    private String city;

    private String street;

    private String house;

    private int entrance;

    private int flat;

}
