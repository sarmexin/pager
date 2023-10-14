package com.sarmexin.postman.controllers;

import com.sarmexin.postman.domain.MessageData;
import com.sarmexin.postman.dto.MessageDto;
import com.sarmexin.postman.services.impl.MessageServiceImpl;
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
@RequestMapping("/message")
@AllArgsConstructor
@Slf4j
public class MessageController {

    private final MessageServiceImpl messageService;

    /**
     * Записать сообщение
     *
     * @param messageDto переданное сообщение
     * @return ок
     */
    @PostMapping("/save")
    public String  saveMessage(@RequestBody MessageDto messageDto) {
        MessageData messageData = messageService.saveMessage(messageDto);

        return "OK";
    }

    /**
     * Получить сообщение из БД
     * @param id id сообщения
     * @return ResponseEntity MessageDto
     */
     @GetMapping("/read")
    public ResponseEntity<MessageDto> readMessage(@RequestParam Long id) {
        MessageDto messageDto = messageService.readMessage(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("test", "testValue");

        return new ResponseEntity<>(messageDto, headers, HttpStatus.OK);
    }

    @GetMapping("/read_all")
    public ResponseEntity<List<MessageDto>> readAllMessage() {
        List<MessageDto> messageDtoList = messageService.readAllMessage();
        log.info("отправление всех сообщений");

        return new ResponseEntity<>(messageDtoList, HttpStatus.OK);
    }
}
