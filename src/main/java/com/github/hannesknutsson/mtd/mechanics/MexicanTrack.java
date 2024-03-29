package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;
import com.github.hannesknutsson.mtd.mechanics.errors.InvalidMoveException;

public class MexicanTrack extends Track {

    public MexicanTrack(final int startingValue) {
        this.currentValue = startingValue;
        this.isBlocker = false;
    }

    public boolean isOpen() {
        return true;
    }

    protected void appendDomino(final Domino toPlace, final Strategy playerMakingTheMove) throws InvalidMoveException {
        if (!toPlace.hasValue(this.currentValue)) {
            throw new InvalidMoveException("The domino that was appended was not legal for this train at the time!");
        }

        if (toPlace.isBlocker()) {
            this.isBlocker = true;
        } else {
            this.currentValue = toPlace.getOtherValue(this.currentValue);
            this.isBlocker = false;
        }
    }
}
