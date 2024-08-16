package com.volkruss.demo.domain.repository.character;

import com.volkruss.demo.domain.dto.character.CharacterEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CharacterRepository {
    List<CharacterEntity> getCharacters();
}
