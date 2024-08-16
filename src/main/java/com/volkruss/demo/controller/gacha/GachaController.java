package com.volkruss.demo.controller.gacha;

import com.volkruss.demo.application.usecase.gacha.GachaUseCase;
import com.volkruss.demo.domain.model.character.Character;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GachaController {
    @Autowired
    private GachaUseCase gachaUseCase;

    @PostMapping("api/playgacha")
    public List<CharacterOut> play() {
        List<Character> characters = this.gachaUseCase.getCharacters();
        return characters.stream()
                .map(CharacterMapper::toOut)
                .collect(Collectors.toList());
    }

    /**
     * 返却オブジェクト
     */
    @AllArgsConstructor
    public static class CharacterOut {
        public String name;

        public static CharacterOut by(String name)
        {
            return new CharacterOut(name);
        }
    }

    /**
     * CharacterをCharacterOutに変換します。
     */
    public static class CharacterMapper {
        static CharacterOut toOut(Character character) {
            return CharacterOut.by(character.getName());
        }
    }
}
