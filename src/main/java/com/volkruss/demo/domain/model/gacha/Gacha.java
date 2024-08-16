package com.volkruss.demo.domain.model.gacha;

import com.volkruss.demo.domain.model.character.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Gacha {
    // ガチャを回すのに必要なコイン
    public final int needCoined = 300;

    // このガチャに登場するキャラリスト
    private List<Character> characters = new ArrayList<>();

    // コンストラクタでガチャに景品を設置しているイメージ
    public Gacha(List<Character> characters) {
        this.characters.addAll(characters);
    }

    // ランダムに登場キャラクターから3体を取得する
    public List<Character> play() {
        Collections.shuffle(this.characters);
        return this.characters.stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}
