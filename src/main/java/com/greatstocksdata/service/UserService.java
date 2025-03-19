package com.greatstocksdata.service;

import com.greatstocksdata.model.dto.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface UserService {

    ResponseEntity<HashMap<String, String>> login(UserRequest payload);

    ResponseEntity<HashMap<String, String>> register(UserRequest payload);
}
