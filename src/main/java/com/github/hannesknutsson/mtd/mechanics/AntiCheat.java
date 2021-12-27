package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AntiCheat {

    private final Strategy suspect;
    private final List<Domino> verificationDominoes;

    public AntiCheat(final Strategy suspect) {
        this.suspect = suspect;
        this.verificationDominoes = new ArrayList<>();
    }

    protected void dealBricks(final List<Domino> bricks) {
        verificationDominoes.clear();
        verificationDominoes.addAll(bricks);
        suspect.setDominoes(Collections.unmodifiableList(bricks));
    }

    protected void addBrick(final Domino brick) {
        verificationDominoes.add(brick);
        suspect.addBrick(brick);
    }

    protected List<Domino> getVerificationDominoes() {
        return Collections.unmodifiableList(verificationDominoes);
    }

    public int getNumberOfRemainingBricks() {
        return verificationDominoes.size();
    }
}
