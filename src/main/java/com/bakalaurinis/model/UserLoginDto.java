package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginDto {
    String email;
    String password;
}
