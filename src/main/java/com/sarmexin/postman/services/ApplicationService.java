package com.sarmexin.postman.services;

import com.sarmexin.postman.domain.application.Application;
import com.sarmexin.postman.dto.application.ApplicationDto;

import java.util.List;

/**
 * @author Sergey Gavrilov
 */
public interface ApplicationService {

    /**
     * Сохранение сообщения
     *
     * @param messageDto объект message для передачи
     * @return сущность message
     */
    Application saveApplication(ApplicationDto messageDto);

    /**
     * Получение сообщения по id
     *
     * @param id идентификатор сообщения в БД
     * @return объект message для передачи
     */
    ApplicationDto readApplication(Long id);

    /**
     * Получение всех сообщений
     *
     * @return список сообщений
     */
    List<ApplicationDto> readAllApplications();

    boolean updateApplication(Long id);
}
