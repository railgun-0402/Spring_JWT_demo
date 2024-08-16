package com.volkruss.demo.application.usecase.user;

import com.volkruss.demo.domain.model.character.Character;

import java.util.List;

public interface UserDataUseCase {
    List<Character> getPossessionList();
}
