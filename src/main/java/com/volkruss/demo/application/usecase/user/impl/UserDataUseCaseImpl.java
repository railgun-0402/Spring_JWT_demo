package com.volkruss.demo.application.usecase.user.impl;

import com.volkruss.demo.application.usecase.user.UserDataUseCase;
import com.volkruss.demo.domain.model.character.Character;
import com.volkruss.demo.domain.model.user.User;
import com.volkruss.demo.domain.repository.stock.StockRepository;
import com.volkruss.demo.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDataUseCaseImpl implements UserDataUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Character> getPossessionList() {
        // キャラクターの一覧を表示する

        // ユーザー名を取得する
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // ユーザ取得
        User user = this.userRepository.findByName(username).toUser();

        return this.stockRepository.getUserCharacters(user.getId())
                .stream().map(i ->
                    new Character(i.getId(), i.getName(), i.getLank()))
                .collect(Collectors.toList());
    }
}
