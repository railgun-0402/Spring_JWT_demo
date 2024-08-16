package com.volkruss.demo.domain.model.user;

import com.volkruss.demo.domain.dto.user.UserEntity;

public interface UserMapper {
    UserEntity toEntity(User user);
}
