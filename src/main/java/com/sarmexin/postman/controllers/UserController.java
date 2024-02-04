//package com.sarmexin.postman.controllers;
//
//import com.sarmexin.postman.services.UserServices;
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Sergey Gavrilov
// */
//@RestController
//@RequestMapping("/user")
//@AllArgsConstructor
//public class UserController {
//
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//
//    private final UserServices userServices;
//
//    @GetMapping("/get")
//    public ResponseEntity<?> getMessage() {
//
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
//}
