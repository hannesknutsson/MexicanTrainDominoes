package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.InvalidMoveException;

/**
 * This class represents a single train in the game
 */
public class PlayerTrack extends MexicanTrack {

    private final Player trainOwner;
    private boolean isOpen;

    protected PlayerTrack(final int startingValue, final Player trainOwner) {
        super(startingValue);
        this.currentValue = startingValue;
        this.trainOwner = trainOwner;
        this.isBlocker = false;
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    protected void appendDomino(final Domino toPlace, final Player playerMakingTheMove) throws InvalidMoveException {
        if (!this.isOpen && !playerMakingTheMove.equals(trainOwner)) {
            throw new InvalidMoveException("This track is not open for everyone to build on at the time!");
        }

        //
        super.appendDomino(toPlace, playerMakingTheMove);

        if (trainOwner.equals(playerMakingTheMove)) {
            this.isOpen = false;
        }
    }






}
