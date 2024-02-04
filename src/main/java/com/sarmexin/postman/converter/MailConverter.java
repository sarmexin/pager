package com.sarmexin.postman.converter;

import com.sarmexin.postman.object.dto.MailDto;
import com.sarmexin.postman.object.entity.Mail;
import org.springframework.stereotype.Component;

@Component
public class MailConverter {

    public MailDto convert(Mail mail) {
        MailDto mailDto = new MailDto();
        mailDto.setId(mail.getId());
        mailDto.setText(mail.getText());

        return mailDto;
    }

}
