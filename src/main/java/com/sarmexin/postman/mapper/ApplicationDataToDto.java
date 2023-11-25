package com.sarmexin.postman.mapper;

import com.sarmexin.postman.entity.Application;
import com.sarmexin.postman.dto.ApplicationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Gavrilov
 */
@Slf4j
@Component
public class ApplicationDataToDto {

    public ApplicationDto map(Application source) {
        ApplicationDto messageDto = new ApplicationDto();
        messageDto.setId(source.getId());
        messageDto.setText(source.getText());
        return messageDto;
    }
}
