package com.sarmexin.postman.converter;

import com.sarmexin.postman.object.dto.MailDto;
import com.sarmexin.postman.object.entity.Mail;
import org.springframework.stereotype.Component;

@Component
public class MailDtoConverter {

    public Mail convert(MailDto mailDto) {
        Mail mail = new Mail();
        mail.setId(mailDto.getId());
        mail.setText(mailDto.getText());

        return mail;
    }
}
