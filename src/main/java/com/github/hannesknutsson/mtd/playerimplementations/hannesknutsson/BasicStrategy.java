package com.github.hannesknutsson.mtd.playerimplementations.hannesknutsson;

import com.github.hannesknutsson.mtd.mechanics.EngineHouse;
import com.github.hannesknutsson.mtd.mechanics.Move;
import com.github.hannesknutsson.mtd.mechanics.Strategy;
import com.github.hannesknutsson.mtd.mechanics.Track;

import java.util.List;

public class BasicStrategy extends Strategy {

    @Override
    public List<Move> makeFirstMoves(EngineHouse engineHouse) {

        for (Track track : engineHouse.getTracks()) {
            //track
        }

        return null;
    }

    @Override
    public List<Move> makeMove(final EngineHouse playingField, final List<Strategy> players) {
        return null;
    }

    @Override
    public String getName() {
        return "Hannes example brain";
    }
}
