package com.sarmexin.postman.mapper;

import com.sarmexin.postman.domain.application.Application;
import com.sarmexin.postman.dto.application.ApplicationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Gavrilov
 */
@Slf4j
@Component
public class ApplicationDtoToData {

    public Application map(ApplicationDto source) {
        Application messageData = new Application();
        messageData.setId(source.getId());
        messageData.setText(source.getText());
        messageData.setAuthorId(source.getAuthorId());
        messageData.setRecipientId(source.getRecipientId());

        return messageData;
    }

}
