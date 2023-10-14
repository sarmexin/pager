package com.sarmexin.postman.services.impl;

import com.sarmexin.postman.annotation.WithLogging;
import com.sarmexin.postman.domain.MessageData;
import com.sarmexin.postman.dto.MessageDto;
import com.sarmexin.postman.mapper.MessageDataToDto;
import com.sarmexin.postman.mapper.MessageDtoToData;
import com.sarmexin.postman.repo.MessageRepository;
import com.sarmexin.postman.services.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;

    private MessageDtoToData converterDtoToData;

    private MessageDataToDto convertDataToDto;

    @Override
    @Transactional
    public MessageData saveMessage(MessageDto messageDto) {
        var messageData = converterDtoToData.map(messageDto);
        MessageData fromTheBaseMessageData = repository.save(messageData);
        log.info("В БД сохранено сообщение с id={}", fromTheBaseMessageData.getId());

        return fromTheBaseMessageData;
    }

    @Override
    public MessageDto readMessage(Long messageId) {
        Optional<MessageData> messageData = repository.findById(messageId);

        return messageData
                .map(data -> convertDataToDto.map(data))
                .orElse(null);

    }

    @Override
    @WithLogging
    public List<MessageDto> readAllMessage() {
        List<MessageData> messageDataList = repository.findAll();
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (MessageData el : messageDataList) {
            messageDtoList.add(convertDataToDto.map(el));
        }

        return messageDtoList;
    }

    @Override
    public boolean updateMessage(Long id) {
        return false;
    }

}
