package com.github.hannesknutsson.mtd.mechanics;

import java.util.List;

/**
 * This class is the base on which players should build their logic
 */
public abstract class Brain {

    private List<Domino> bricks;

    public void setBricks(final List<Domino> bricks) {
        this.bricks = bricks;
    }
}
