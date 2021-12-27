package com.github.hannesknutsson.mtd.mechanics;

import java.util.ArrayList;
import java.util.List;

public class MexicanPlayer extends Strategy {
    @Override
    public List<Move> makeFirstMoves(EngineHouse playingField) {
        return new ArrayList<>();
    }

    @Override
    public List<Move> makeMove(EngineHouse playingField, List<Strategy> players) {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return "MEXICAN PLAYER";
    }
}
