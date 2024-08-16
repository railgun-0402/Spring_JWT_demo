package com.volkruss.demo.domain.dto.character;

import com.volkruss.demo.domain.model.character.Character;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterEntity {
    private int id;
    private String name;
    private int lank;

    public Character toCharacter() {
        return new Character(id, name, lank);
    }
}
