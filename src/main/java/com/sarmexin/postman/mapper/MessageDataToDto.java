package com.sarmexin.postman.mapper;

import com.sarmexin.postman.domain.MessageData;
import com.sarmexin.postman.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageDataToDto {

    public MessageDto map(MessageData source) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(source.getId());
        messageDto.setText(source.getText());
        return messageDto;
    }
}
