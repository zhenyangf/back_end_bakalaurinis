package com.bakalaurinis.services;

import com.bakalaurinis.model.*;
import com.bakalaurinis.repository.InsuranceRepository;
import com.bakalaurinis.repository.RoleRepository;
import com.bakalaurinis.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;



    public UserDtoWithId register(UserRegistrationDto user){
        System.out.println(user.getPassword());
        if(userRepository.findByEmail(user.getEmail()) ==null) {
            user.setPassword(user.getPassword());
        }
        else {
            System.out.println("email exsists already");
            return null;
        }
        return saveUser(user);
    }


    public UserDtoWithId saveUser(UserRegistrationDto user){
        Role role = roleRepository.findByName("USER");
        User saveduser = UserMapper.toRegistrationUser(user,role);

        userRepository.save(saveduser);
        return UserMapper.toUserDtoWithId(saveduser);
    }

    public UserDtoWithId login(UserLoginDto userLoginDto){
        if(userRepository.findByEmailAndPassword(userLoginDto.getEmail(),userLoginDto.getPassword())==null){
            throw new ResponseStatusException((HttpStatus.FORBIDDEN));
        }
        else{
            User saveduser = userRepository.findByEmail(userLoginDto.getEmail());

            return UserMapper.toUserDtoWithId(saveduser);
        }

    }

    public List<User> getUsers(){

        return userRepository.findAll();
    }




    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found by id" +id));
        return user.get();
    }
    public UserDtoWithId updateUser(UserRegistrationDto user){
        return saveUser(user);
    }


    public Optional<UserDto> getUserDto(Long id){
        return userRepository.findById(id).map(UserMapper::toUserDto);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user==null){
            System.out.println("not found user");
            throw new UsernameNotFoundException("user not found");
        }else {
            System.out.println("found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
