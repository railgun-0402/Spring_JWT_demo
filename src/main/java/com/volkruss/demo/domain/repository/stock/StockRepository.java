package com.volkruss.demo.domain.repository.stock;

import com.volkruss.demo.domain.dto.character.CharacterEntity;
import com.volkruss.demo.domain.dto.stock.StockEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockRepository {
    List<CharacterEntity> getUserCharacters(int user_id);
    void save(List<StockEntity> stocks);
}
