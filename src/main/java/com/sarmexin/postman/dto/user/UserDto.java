package com.sarmexin.postman.dto.user;

import com.sarmexin.postman.dto.Address;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Sergey Gavrilov
 */
@Data
public class UserDto {

    private long id;

    private Address address;

}
