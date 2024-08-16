package com.volkruss.demo.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coin {
    private int amt;

    /**
     * コインをマイナスします
     * @param sub
     * @return
     */
    public Coin sub(int sub) {
        this.amt -= sub;
        return this;
    }

    /**
     * コインをプラスします
     * @param add
     * @return
     */
    public Coin add(int add) {
        this.amt += add;
        return this;
    }

    /**
     * 所持しているコインの数を返します
     * @return
     */
    public int  getAmt() {
        return this.amt;
    }

    /**
     * ガチャが引けるかどうか判定します
     * @param need
     * @return
     */
    public boolean canGacha(int need) {
        if (this.amt - need < 0) {
            return false;
        }
        return true;
    }
}
