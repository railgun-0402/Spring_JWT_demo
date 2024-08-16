package com.volkruss.demo.domain.model.user;

import com.volkruss.demo.domain.dto.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    /**
     * Mapperで取得したUserをUserEntityに変換する
     * @param user
     * @return UserEntity
     */
    @Override
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setCoin(user.getCoin());
        return entity;
    }
}
