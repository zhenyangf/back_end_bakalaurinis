//package com.bakalaurinis.api;
//
//import com.bakalaurinis.model.User;
//import com.bakalaurinis.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.apache.coyote.Response;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class UserResource {
//    private final UserService userService;
//    @GetMapping("/allusers")
//    public ResponseEntity<List<User>>getUser(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }
//}
