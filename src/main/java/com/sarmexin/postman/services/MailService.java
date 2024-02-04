package com.sarmexin.postman.services;

import com.sarmexin.postman.object.dto.MailDto;

import java.util.List;

public interface MailService {

    Boolean saveMail(MailDto mailDto);

    List<MailDto> getAll();
}
