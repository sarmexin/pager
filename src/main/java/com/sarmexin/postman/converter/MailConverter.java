package com.sarmexin.postman.converter;

import com.sarmexin.postman.object.dto.MailDto;
import com.sarmexin.postman.object.entity.Mail;
import org.springframework.stereotype.Component;

@Component
public class MailConverter {

    public MailDto convert(Mail mail) {

        return MailDto.builder()
                .id(mail.getId())
                .timeCreation(mail.getTimeCreation())
                .text(mail.getText())
                .build();
    }

}
