package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class UserRegistrationDto {
    String password;
    String email;
    String name;
    String surname;
    String phone;



}
