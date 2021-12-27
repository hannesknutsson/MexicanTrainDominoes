package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.OutOfBricksException;

public class DrawBrick extends Move {

    @Override
    protected void executeMove(final Player playerMakingTheMove, final Round currentRound) throws OutOfBricksException {
        playerMakingTheMove.getStrategy().addBrick(currentRound.getBrickPile().drawRandomBrick());
    }
}
