package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;

import java.util.ArrayList;
import java.util.List;

/**
 * A base class for players to extend.
 */
public abstract class Strategy implements Name {

    protected final List<Domino> dominoesOnHand;

    protected Strategy() {
        dominoesOnHand = new ArrayList<>();
    }

    protected void setDominoes(final List<Domino> bricks) {
        dominoesOnHand.clear();
        dominoesOnHand.addAll(bricks);
    }

    protected void addBrick(final Domino toAdd) {
        dominoesOnHand.add(toAdd);
    }

    protected abstract List<Move> makeFirstMoves(final EngineHouse playingField);

    protected abstract List<Move> makeMove(final EngineHouse playingField, final List<Strategy> players);
}
