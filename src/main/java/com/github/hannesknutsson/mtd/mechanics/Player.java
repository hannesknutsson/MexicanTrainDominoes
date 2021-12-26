package com.github.hannesknutsson.mtd.mechanics;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that keeps track on what bricks a player has been dealt to prevent cheating
 */
public class Player {

    private final Brain brain;
    private final List<Domino> bricks;

    public Player(final Brain brain, List<Domino> bricks) {
        brain.setBricks(new ArrayList<Domino>(bricks));
        this.brain = brain;
        this.bricks = bricks;
    }
}
