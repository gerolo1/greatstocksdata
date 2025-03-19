package com.greatstocksdata.controller;

import com.greatstocksdata.model.dto.CustomerRequest;
import com.greatstocksdata.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody CustomerRequest payload) {
        return customerService.login(payload);
    }

    @PostMapping("/register")
    public ResponseEntity<HashMap<String, String>> register(@RequestBody CustomerRequest payload) {
        return customerService.register(payload);
    }
}
