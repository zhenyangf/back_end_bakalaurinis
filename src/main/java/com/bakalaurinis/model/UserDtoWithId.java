package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDtoWithId {
    String password;
    String email;
    String name;
    String surname;
    String phone;
    Long id;

}
