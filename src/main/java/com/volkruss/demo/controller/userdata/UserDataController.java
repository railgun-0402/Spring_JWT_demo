package com.volkruss.demo.controller.userdata;

import com.volkruss.demo.application.usecase.user.UserDataUseCase;
import com.volkruss.demo.controller.gacha.GachaController;
import com.volkruss.demo.domain.model.character.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserDataController {
    @Autowired
    private UserDataUseCase userDataUseCase;

    @GetMapping("api/stock")
    public List<GachaController.CharacterOut> mylist() {
        // ユーザに紐づく取得キャラ
        List<Character> characters = this.userDataUseCase.getPossessionList();
        return characters
                .stream().map(GachaController.CharacterMapper::toOut)
                .collect(Collectors.toList());
    }
}
