package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;
import com.github.hannesknutsson.mtd.mechanics.errors.InvalidMoveException;

/**
 * This class represents a single train in the game
 */
public class PlayerTrack extends MexicanTrack {

    public final Player trackOwner;
    private boolean isOpen;

    public PlayerTrack(final int startingValue, final Player trainOwner) {
        super(startingValue);
        this.currentValue = startingValue;
        this.trackOwner = trainOwner;
        this.isBlocker = false;
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    protected void appendDomino(final Domino toPlace, final Strategy playerMakingTheMove) throws InvalidMoveException {
        if (!this.isOpen && !playerMakingTheMove.equals(trackOwner)) {
            throw new InvalidMoveException("This track is not open for everyone to build on at the time!");
        }

        super.appendDomino(toPlace, playerMakingTheMove);

        if (trackOwner.equals(playerMakingTheMove)) {
            this.isOpen = false;
        }
    }






}
