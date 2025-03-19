package com.greatstocksdata.service.impl;

import com.greatstocksdata.utils.PasswordUtils;
import com.greatstocksdata.utils.jwt.JwtUtil;
import com.greatstocksdata.model.dto.CustomerRequest;
import com.greatstocksdata.model.entity.Customer;
import com.greatstocksdata.repository.CustomerRepository;
import com.greatstocksdata.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<HashMap<String, String>> login(CustomerRequest payload) {
        log.info("INIT: UserServiceImpl - login - {}", payload.getUsername());

        log.info("INIT: UserRepository - findByUsername");
        Optional<Customer> user = customerRepository.findByUsername(payload.getUsername());
        log.info("END: UserRepository - findByUsername");

        if(user.isPresent() && PasswordUtils.validatePassword(payload.getPassword(), user.get().getPassword())) {
            String token = jwtUtil.generateToken(payload.getUsername());

            HashMap<String, String> response = new HashMap<>();
            response.put("token", token);

            log.info("END: UserServiceImpl - login - {}", payload.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        log.error("Invalid username or password");
        throw new IllegalArgumentException("Invalid username or password");
    }

    @Override
    public ResponseEntity<HashMap<String, String>> register(CustomerRequest payload) {
        log.info("INIT: UserServiceImpl - register - {}", payload.getUsername());

        if(payload.getUsername() == null || payload.getUsername().isEmpty()) {
            log.error("Invalid username");
            throw new IllegalArgumentException("Invalid username");
        }

        if(payload.getPassword() == null || payload.getPassword().isEmpty() || payload.getPassword().length() < 8) {
            log.error("Invalid password");
            throw new IllegalArgumentException("Invalid password");
        }

        payload.setPassword(PasswordUtils.hashPassword(payload.getPassword()));

        customerRepository.save(payload.toEntity());

        log.info("END: UserServiceImpl - register - {}", payload.getUsername());

        HashMap<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
