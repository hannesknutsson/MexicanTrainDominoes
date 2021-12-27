package com.github.hannesknutsson.mtd.mechanics.bricks;

import java.util.ArrayList;
import java.util.List;

public class BrickPileFactory {

    public BrickPile createBrickPile() {

        List<Domino> bricks = new ArrayList<>();

        int valueLimit = 13;

        for (int i = valueLimit ; i >= 0 ; i--) {
            for (int j = 0 ; j <= valueLimit ; j ++) {
                bricks.add(new Domino(i, j));
            }
            valueLimit--;
        }
        return new BrickPile(bricks);
    }
}
