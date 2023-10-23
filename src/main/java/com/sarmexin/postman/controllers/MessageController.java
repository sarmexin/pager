package com.sarmexin.postman.controllers;

import com.sarmexin.postman.domain.application.Application;
import com.sarmexin.postman.dto.application.ApplicationDto;
import com.sarmexin.postman.services.impl.ApplicationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sergey Gavrilov
 */
@RestController
@RequestMapping("/application")
@AllArgsConstructor
@Slf4j
public class MessageController {

    private final ApplicationServiceImpl applicationService;

    /**
     * Записать сообщение
     *
     * @param messageDto переданное сообщение
     * @return ок
     */
    @PostMapping("/save")
    public String saveApplication(@RequestBody ApplicationDto messageDto) {
        Application messageData = applicationService.saveApplication(messageDto);

        return "OK";
    }

    /**
     * Получить сообщение из БД
     *
     * @param id id сообщения
     * @return ResponseEntity MessageDto
     */
    @GetMapping("/read")
    public ResponseEntity<ApplicationDto> readApplications(@RequestParam Long id) {
        ApplicationDto messageDto = applicationService.readApplication(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("test", "testValue");

        return new ResponseEntity<>(messageDto, headers, HttpStatus.OK);
    }

    @GetMapping("/read_all")
    public ResponseEntity<List<ApplicationDto>> readAllApplications() {
        List<ApplicationDto> messageDtoList = applicationService.readAllApplications();
        log.info("отправление всех сообщений");

        return new ResponseEntity<>(messageDtoList, HttpStatus.OK);
    }
}
