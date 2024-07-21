package com.volkruss.demo.config;

import com.volkruss.demo.domain.dto.user.UserEntity;
import com.volkruss.demo.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity userEntity = userRepository.findByName(username);
            // 認可があればここで設定できる
            // org.springframework.security.core.userdetails.Userにして返却する
            // パスワードエンコーダを利用してパスワードはエンコードをかける
            return new User(userEntity.getName(), PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userEntity.getPassword()), new ArrayList<>());

        } catch (Exception e) {
            throw new UsernameNotFoundException("ユーザーが見つかりません");
        }
    }
}
