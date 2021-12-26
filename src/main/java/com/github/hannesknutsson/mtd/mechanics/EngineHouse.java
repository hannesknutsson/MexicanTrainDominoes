package com.github.hannesknutsson.mtd.mechanics;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains trains, including the Mexican train
 */
public class EngineHouse {

    private List<Track> tracks;

    public EngineHouse(final int startingValue, final List<Player> players) {
        this.tracks = new ArrayList<>();
        tracks.add(new MexicanTrack(startingValue));
        for (Player player : players) {
            this.tracks.add(new PlayerTrack(startingValue, player));
        }
    }
}
