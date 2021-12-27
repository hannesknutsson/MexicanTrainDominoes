package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.OutOfBricksException;

public abstract class Move {

    protected abstract void executeMove(final Player playerMakingTheMove, final Round currentRound) throws OutOfBricksException;

}
