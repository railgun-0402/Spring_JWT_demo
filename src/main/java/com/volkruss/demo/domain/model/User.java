package com.volkruss.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * ユーザに関するエンティティ
 */
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int coin;
}
