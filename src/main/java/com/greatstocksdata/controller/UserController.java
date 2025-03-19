package com.greatstocksdata.controller;

import com.greatstocksdata.model.dto.UserRequest;
import com.greatstocksdata.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody UserRequest payload) {
        return userService.login(payload);
    }

    @PostMapping("/register")
    public ResponseEntity<HashMap<String, String>> register(@RequestBody UserRequest payload) {
        return userService.register(payload);
    }
}
