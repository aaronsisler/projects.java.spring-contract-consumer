package com.ebsolutions.spring_cdc.consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping()
    public ResponseEntity<String> getHello() {
        return ResponseEntity.status((200)).body("Hello from Consumer App!");
    }
}
