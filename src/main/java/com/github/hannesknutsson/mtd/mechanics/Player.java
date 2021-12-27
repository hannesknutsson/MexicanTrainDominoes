package com.github.hannesknutsson.mtd.mechanics;

public final class Player implements Name {

    private final Strategy strategy;
    private final AntiCheat antiCheat;

    private Player(final Strategy strategy, final AntiCheat antiCheat) {
        this.strategy = strategy;
        this.antiCheat = antiCheat;
    }

    public final int getNumberOfRemainingBricks() {
        return antiCheat.getNumberOfRemainingBricks();
    }

    public static Player createPlayer(final Strategy strategy) {
        return new Player(strategy, new AntiCheat(strategy));
    }

    @Override
    public String getName() {
        return strategy.getName();
    }

    protected final Strategy getStrategy() {
        return strategy;
    }

    protected final AntiCheat getAntiCheat() {
        return antiCheat;
    }
}
