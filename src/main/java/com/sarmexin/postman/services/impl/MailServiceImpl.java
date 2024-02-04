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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    public static final String TIME_PATTERN = "YYYY:MM:dd-HH:mm:ss";

    private final MailRepository mailRepository;

    private final MailDtoConverter mailDtoConverter;

    private final MailConverter mailConverter;

    @Override
    public Boolean saveMail(MailDto mailDto) {
        Mail mail = mailDtoConverter.convert(mailDto);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIME_PATTERN));
        mail.setTimeCreation(time);
        mailRepository.save(mail);
        log.info("В БД записали " + mail);

        return true;
    }

    @Override
    public List<MailDto> getAll() {

        return mailRepository.findAll()
                .stream()
                .map(mailConverter::convert)
                .collect(Collectors.toList());
    }

}




