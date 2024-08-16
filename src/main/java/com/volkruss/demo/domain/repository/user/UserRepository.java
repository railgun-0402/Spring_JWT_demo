package com.volkruss.demo.domain.repository.user;

import com.volkruss.demo.domain.dto.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserEntity findByName(String name);
    void updateCoin(UserEntity userEntity);
}
