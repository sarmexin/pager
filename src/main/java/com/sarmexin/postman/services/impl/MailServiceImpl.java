package com.sarmexin.postman.services.impl;

import com.sarmexin.postman.controllers.MailController;
import com.sarmexin.postman.converter.MailConverter;
import com.sarmexin.postman.converter.MailDtoConverter;
import com.sarmexin.postman.object.dto.MailDto;
import com.sarmexin.postman.object.entity.Mail;
import com.sarmexin.postman.repository.MailRepository;
import com.sarmexin.postman.services.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    private final MailRepository mailRepository;

    private final MailDtoConverter mailDtoConverter;

    private final MailConverter mailConverter;

    @Override
    public Boolean saveMail(MailDto mailDto) {

        Mail mail = mailDtoConverter.convert(mailDto);

        mailRepository.save(mail);

        log.info("В БД записали " + mail);

        return true;
    }

    @Override
    public List<MailDto> getAll() {

        List<Mail> mail = mailRepository.findAll();
        MailDto mailDto = mailConverter.convert(mail);
        return null;
    }

}




