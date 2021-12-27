package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;
import com.github.hannesknutsson.mtd.mechanics.errors.OutOfBricksException;

/**
 * Represents a player action of placing a domino on a track
 */
public class PlaceDomino extends Move {

    final public Domino toPlace;
    final public Track trackToExtend;

    public PlaceDomino(final Domino toPlace, final Track trackToExtend) {
        this.toPlace = toPlace;
        this.trackToExtend = trackToExtend;
    }

    @Override
    protected void executeMove(Player playerMakingTheMove, Round currentRound) throws OutOfBricksException {

    }
}
