package com.greatstocksdata.model.dto;

import com.greatstocksdata.model.entity.Customer;
import lombok.Data;

@Data
public class CustomerRequest {
    private String username;
    private String password;

    public Customer toEntity() {
        Customer user = new Customer();

        user.setUsername(getUsername());
        user.setPassword(getPassword());

        return user;
    }
}
