package com.sarmexin.postman.mapper;

import com.sarmexin.postman.domain.application.ApplicationData;
import com.sarmexin.postman.dto.application.ApplicationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Gavrilov
 */
@Slf4j
@Component
public class ApplicationDtoToData {

    public ApplicationData map(ApplicationDto source) {
        ApplicationData messageData = new ApplicationData();
        messageData.setId(source.getId());
        messageData.setText(source.getText());
        messageData.setAuthorId(source.getAuthorId());
        messageData.setRecipientId(source.getRecipientId());

        return messageData;
    }

}
