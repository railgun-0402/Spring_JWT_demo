package com.volkruss.demo.application.usecase.gacha.impl;

import com.volkruss.demo.application.usecase.gacha.GachaUseCase;
import com.volkruss.demo.domain.model.character.Character;
import com.volkruss.demo.domain.model.gacha.Gacha;
import com.volkruss.demo.domain.model.user.User;
import com.volkruss.demo.domain.model.user.UserMapper;
import com.volkruss.demo.domain.repository.character.CharacterRepository;
import com.volkruss.demo.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GachaUseCaseImpl implements GachaUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Character> getCharacters() {
        // ユーザ取得
        User user = this.userRepository.findByName("zenn").toUser();
        // キャラクターの取得
        List<Character> characters = this.characterRepository.getCharacters()
                .stream().map(
                i -> new Character(i.getId(),i.getName(),i.getLank())
        ).collect(Collectors.toList());

        // ガチャの作成
        Gacha gacha = new Gacha(characters);
        // ユーザがコインを利用する
        user.useCoin(gacha.needCoined);

        // ガチャの利用（キャラクターをランダム3人取得）
        List<Character> characterList = gacha.play();
        // ユーザー情報の更新
        this.userRepository.updateCoin(this.userMapper.toEntity(user));

        return characterList;
    }
}
