package com.sarmexin.postman.controllers;

import com.sarmexin.postman.object.dto.MailDto;
import com.sarmexin.postman.services.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
@Slf4j
public class MailController {

    private final MailService mailService;

    @PostMapping("/save")
    public String saveMail(@RequestBody MailDto mailDto) {

        boolean resultSaveMail = mailService.saveMail(mailDto);

        return resultSaveMail ? "Сохранено в БД" : "Неуспешное сохранение";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MailDto>> getAllMail() {

        List<MailDto> mailDto = mailService.getAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Return Mails", "ok");

        return new ResponseEntity<>(mailDto, headers, HttpStatus.OK);
    }
}