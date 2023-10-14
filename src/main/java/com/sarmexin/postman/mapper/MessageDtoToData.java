package com.sarmexin.postman.mapper;

import com.sarmexin.postman.domain.MessageData;
import com.sarmexin.postman.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageDtoToData {

    public MessageData map(MessageDto source) {
        MessageData messageData = new MessageData();
        messageData.setId(source.getId());
        messageData.setText(source.getText());
        messageData.setAuthorId(source.getAuthorId());
        messageData.setRecipientId(source.getRecipientId());

        return messageData;
    }

}
