package com.sarmexin.postman.object.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailDto {

    private Long id;

    private String timeCreation;

    private String text;

}
