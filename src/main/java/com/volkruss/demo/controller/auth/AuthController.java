package com.volkruss.demo.controller.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/api/islogin")
    public boolean isLogin() {
        return true;
    }
}
