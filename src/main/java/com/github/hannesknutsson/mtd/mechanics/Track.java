package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.InvalidMoveException;

public abstract class Track {

    public abstract boolean isOpen();

    protected abstract void appendDomino(final Domino toPlace, final Player playerMakingTheMove) throws InvalidMoveException;






}
