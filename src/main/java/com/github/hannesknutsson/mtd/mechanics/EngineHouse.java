package com.github.hannesknutsson.mtd.mechanics;

import java.util.*;

/**
 * Contains trains, including the Mexican train
 */
public class EngineHouse {

    private Map<Player, Track> tracks;
    private List<Player> players;

    private static final Strategy DUMMY_STRATEGY = new MexicanPlayer();
    private static final Player MEXICAN_PLAYER = Player.createPlayer(DUMMY_STRATEGY);

    public EngineHouse(final int startingValue, final List<Player> players) {
        this.tracks = new HashMap<>();
        tracks.put(MEXICAN_PLAYER, new MexicanTrack(startingValue));
        this.players = players;
        for (Player player : players) {
            this.tracks.put(player, new PlayerTrack(startingValue, player));
        }
    }

    public List<Track> getTracks() {
        return List.copyOf(tracks.values());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Track getPlayerTrack(final Player trackOwner) {
        return tracks.values().stream()
                .filter(track -> track instanceof PlayerTrack && ((PlayerTrack) track).trackOwner.equals(trackOwner))
                .findAny().get();
    }

    public Track getMexicanTrack() {
        return tracks.values().stream().filter(track -> track instanceof MexicanTrack).findAny().get();
    }
}
