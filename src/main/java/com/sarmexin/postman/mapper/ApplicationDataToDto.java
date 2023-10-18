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
public class ApplicationDataToDto {

    public ApplicationDto map(ApplicationData source) {
        ApplicationDto messageDto = new ApplicationDto();
        messageDto.setId(source.getId());
        messageDto.setText(source.getText());
        return messageDto;
    }
}
