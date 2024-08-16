package com.volkruss.demo.domain.repository.user;

import com.volkruss.demo.domain.dto.user.UserEntity;
import com.volkruss.demo.domain.model.user.User;
import com.volkruss.demo.domain.model.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_findByName() {
        UserEntity userEntity = this.userRepository.findByName("zenn");
        assertEquals("zenn", userEntity.getName());
    }

    @Test
    public void test_update() {
        UserEntity userEntity = this.userRepository.findByName("zenn");
        assertEquals(900, userEntity.getCoin());
        User user = userEntity.toUser();
        user.useCoin(300);

        // マッパーの利用
        UserEntity afterEntity = this.userMapper.toEntity(user);
        this.userRepository.updateCoin(afterEntity);

        // 更新後のUserデータ確認
        UserEntity afterUserEntity = this.userRepository.findByName("zenn");
        assertEquals(600, afterUserEntity.getCoin());
    }
}