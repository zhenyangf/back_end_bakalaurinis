package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    Long id;
    String email;
    String name;
    String surname;
    String phone;
}
