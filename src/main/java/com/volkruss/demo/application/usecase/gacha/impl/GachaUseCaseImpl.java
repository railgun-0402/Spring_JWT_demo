package com.volkruss.demo.application.usecase.gacha.impl;

import com.volkruss.demo.application.exception.coin.NotEnoughException;
import com.volkruss.demo.application.usecase.gacha.GachaUseCase;
import com.volkruss.demo.domain.dto.stock.StockEntity;
import com.volkruss.demo.domain.model.character.Character;
import com.volkruss.demo.domain.model.gacha.Gacha;
import com.volkruss.demo.domain.model.user.User;
import com.volkruss.demo.domain.model.user.UserMapper;
import com.volkruss.demo.domain.repository.character.CharacterRepository;
import com.volkruss.demo.domain.repository.stock.StockRepository;
import com.volkruss.demo.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class GachaUseCaseImpl implements GachaUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Character> getCharacters() {
        // ユーザー名を取得する
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // ユーザ取得
        User user = this.userRepository.findByName(username).toUser();
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

        // キャラクターの登録
        List<StockEntity> stockEntities = characterList.stream().map(i -> {
            return new StockEntity(user.getId(), i.getId());
        }).collect(Collectors.toList());

        this.stockRepository.save(stockEntities);

        return characterList;
    }
}
