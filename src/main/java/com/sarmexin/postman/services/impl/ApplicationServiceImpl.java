package com.sarmexin.postman.services.impl;

import com.sarmexin.postman.annotation.WithLogging;
import com.sarmexin.postman.domain.application.ApplicationData;
import com.sarmexin.postman.dto.application.ApplicationDto;
import com.sarmexin.postman.mapper.ApplicationDataToDto;
import com.sarmexin.postman.mapper.ApplicationDtoToData;
import com.sarmexin.postman.repository.ApplicationRepository;
import com.sarmexin.postman.services.ApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Sergey Gavrilov
 */
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository repository;

    private ApplicationDtoToData converterDtoToData;

    private ApplicationDataToDto convertDataToDto;

    @Override
    @Transactional
    public ApplicationData saveApplication(ApplicationDto messageDto) {
        var messageData = converterDtoToData.map(messageDto);
        ApplicationData fromTheBaseMessageData = repository.save(messageData);
        log.info("В БД сохранено сообщение с id={}", fromTheBaseMessageData.getId());

        return fromTheBaseMessageData;
    }

    @Override
    public ApplicationDto readApplication(Long messageId) {
        Optional<ApplicationData> messageData = repository.findById(messageId);

        return messageData
                .map(data -> convertDataToDto.map(data))
                .orElse(null);
    }

    @Override
//    @WithLogging(service = "readAllApplications")
    public List<ApplicationDto> readAllApplications() {
        List<ApplicationData> messageDataList = repository.findAll();
        List<ApplicationDto> messageDtoList = new ArrayList<>();
        for (ApplicationData el : messageDataList) {
            messageDtoList.add(convertDataToDto.map(el));
        }

        return messageDtoList;
    }

    @Override
    public boolean updateApplication(Long id) {
        return false;
    }

}
