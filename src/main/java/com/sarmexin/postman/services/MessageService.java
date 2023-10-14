package com.sarmexin.postman.services;

import com.sarmexin.postman.domain.MessageData;
import com.sarmexin.postman.dto.MessageDto;

import java.util.List;

/**
 * @author Sergey Gavrilov
 */
public interface MessageService {

    /**
     * Сохранение сообщения
     *
     * @param messageDto объект message для передачи
     * @return сущность message
     */
    MessageData saveMessage(MessageDto messageDto);

    /**
     * Получение сообщения по id
     *
     * @param id идентификатор сообщения в БД
     * @return объект message для передачи
     */
    MessageDto readMessage(Long id);

    /**
     * Получение всех сообщений
     *
     * @return список сообщений
     */
    List<MessageDto> readAllMessage();

    boolean updateMessage(Long id);
}
