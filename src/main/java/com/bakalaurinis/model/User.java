package com.bakalaurinis.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Insurance> insurances;
    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();


    public User(String name, String surname, String email, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }



}
