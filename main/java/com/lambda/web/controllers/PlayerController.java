package com.lambda.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @GetMapping("")
    public String home(){
        return "반갑다 ㅎㅇ";
    }
}
