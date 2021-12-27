package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;
import com.github.hannesknutsson.mtd.mechanics.errors.InvalidMoveException;

public abstract class Track {

    protected int currentValue;
    protected boolean isBlocker;

    public int getCurrentValue() {
        return currentValue;
    }

    public abstract boolean isOpen();

    protected abstract void appendDomino(final Domino toPlace, final Strategy playerMakingTheMove) throws InvalidMoveException;






}
