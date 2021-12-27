package com.github.hannesknutsson.mtd.mechanics.bricks;

import com.github.hannesknutsson.mtd.mechanics.errors.GameIsBrokenException;
import com.github.hannesknutsson.mtd.mechanics.errors.OutOfBricksException;

import java.util.Collections;
import java.util.List;

public class BrickPile {

    private final List<Domino> bricks;

    public BrickPile(final List<Domino> bricks) {
        this.bricks = bricks;
    }

    public Domino drawRandomBrick() throws OutOfBricksException {
        checkForOutOfBricks();
        Collections.shuffle(bricks);
        final int brickToDraw = (int) (Math.random() * bricks.size());
        return bricks.remove(brickToDraw);
    }

    public Domino removeBrick(final Domino toRemove) throws GameIsBrokenException, OutOfBricksException {
        checkForOutOfBricks();
        Domino toBeRemovedFromPile = null;
        for (Domino brick : bricks) {
            if (brick.equals(toRemove)) {
                toBeRemovedFromPile = brick;
                break;
            }
        }

        if (toBeRemovedFromPile == null) {
            throw new GameIsBrokenException("Could not remove brick " + toRemove + ". The brick seems to be missing in the brick pile.");
        }

        bricks.remove(toBeRemovedFromPile);
        return toBeRemovedFromPile;
    }

    private void checkForOutOfBricks() throws OutOfBricksException {
        if (bricks.size() == 0) {
            throw new OutOfBricksException("There are no more bricks to draw from the pile");
        }
    }
}
