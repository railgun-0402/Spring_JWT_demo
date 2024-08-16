package com.volkruss.demo.application.usecase.gacha;

import com.volkruss.demo.domain.model.character.Character;

import java.util.List;

public interface GachaUseCase {
    List<Character> getCharacters();
}
