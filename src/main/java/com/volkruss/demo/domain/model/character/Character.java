package com.volkruss.demo.domain.model.character;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Character {
    private final int id;
    private final String name;
    private final int lank;
}
