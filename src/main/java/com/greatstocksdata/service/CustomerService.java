package com.greatstocksdata.service;

import com.greatstocksdata.model.dto.CustomerRequest;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface CustomerService {

    ResponseEntity<HashMap<String, String>> login(CustomerRequest payload);

    ResponseEntity<HashMap<String, String>> register(CustomerRequest payload);
}
