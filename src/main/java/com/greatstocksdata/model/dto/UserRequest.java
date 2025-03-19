package com.greatstocksdata.model.dto;

import com.greatstocksdata.model.entity.User;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;

    public User toEntity() {
        User user = new User();

        user.setUsername(getUsername());
        user.setPassword(getPassword());

        return user;
    }
}
