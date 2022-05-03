package com.bakalaurinis.controller;

import com.bakalaurinis.model.UserDto;
import com.bakalaurinis.model.UserDtoWithId;
import com.bakalaurinis.model.UserLoginDto;
import com.bakalaurinis.model.UserRegistrationDto;
import com.bakalaurinis.repository.UserRepository;
import com.bakalaurinis.services.UserService;
import lombok.RequiredArgsConstructor;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.wsdl.Output;
import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
        public UserDtoWithId login(@RequestBody UserLoginDto userdto) {

        return userService.login(userdto);
    }

    @PostMapping("/register")
    public UserDtoWithId registerUser(@RequestBody UserRegistrationDto user){
        return userService.register(user);
    }


//idet kad grazintu dar id

//    @Multipart
//    @POST("/upload")
//    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);

//    @PutMapping("/user/update")
//    public UserRegistrationDto updateUser(@RequestBody UserRegistrationDto userDto){
//        return userService.updateUser(userDto);
//    }
    @GetMapping("/user/{id}")
    public Optional<UserDto> getuser(@PathVariable Long id){
        return userService.getUserDto(id);
    }
    @GetMapping("/")
    String hello(){
        return "hello ";
    }




}
