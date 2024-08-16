package com.volkruss.demo.domain.model.user;

import com.volkruss.demo.application.exception.coin.NotEnoughException;
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
    private int id;
    private String name;
    private Coin coin;

    public void useCoin(int pay) {
        if (this.coin.canGacha(pay)) {
            // 使用したらコインがひかれる
            this.coin = this.coin.sub(pay);
        } else {
            // error
            throw new NotEnoughException();
        }
    }

    public void buyCoin(int amt) {
        this.coin = this.coin.add(amt);
    }

    public int getCoin() {
        return this.coin.getAmt();
    }
}
