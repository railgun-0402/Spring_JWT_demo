package com.volkruss.demo.domain.dto.user;

import com.volkruss.demo.domain.model.User;
import lombok.Getter;
import lombok.Setter;

/**
 * データアクセスのために使われるDTO
 */
@Getter
@Setter
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private int coin;

    public User toUser() {
        return new User(name, coin);
    }
}
