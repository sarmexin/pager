package com.sarmexin.postman.dto;

import lombok.Data;

/**
 * @author Sergey Gavrilov
 */
@Data
public class ApplicationDto {

    private long id;

    private String text;

    private long authorId;

    private long recipientId;

}
