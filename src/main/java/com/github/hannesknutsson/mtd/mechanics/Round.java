package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.bricks.BrickPile;
import com.github.hannesknutsson.mtd.mechanics.bricks.BrickPileFactory;
import com.github.hannesknutsson.mtd.mechanics.bricks.Domino;
import com.github.hannesknutsson.mtd.mechanics.errors.EdgeCaseException;
import com.github.hannesknutsson.mtd.mechanics.errors.GameIsBrokenException;
import com.github.hannesknutsson.mtd.mechanics.errors.OutOfBricksException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Round {

    private final int roundNumber;
    private final EngineHouse engineHouse;
    private final List<Player> players;
    private final BrickPile brickPile;
    private boolean roundAlreadyPlayed;
    private static final Map<Integer, Integer> playersToBricksMap = Map.ofEntries(
            entry(2, 16),
            entry(3, 15),
            entry(4, 14),
            entry(5, 12),
            entry(6, 11),
            entry(7, 10),
            entry(8, 9)
    );

    public Round(final int roundNumber, final List<Player> players) {
        this.brickPile = new BrickPileFactory().createBrickPile();
        this.roundNumber = roundNumber;
        this.engineHouse = new EngineHouse(this.roundNumber, players);
        this.players = players;
        this.roundAlreadyPlayed = false;
    }

    public Map<Strategy, Integer> play() throws GameIsBrokenException, EdgeCaseException {
        if (roundAlreadyPlayed) {
            throw new GameIsBrokenException("This round has already been played");
        }
        roundAlreadyPlayed = true;

        setupRound();
        firstTurn();


        return null; //TODO: Return something useful, lmao
    }

    private void firstTurn() {
        for (Player player : players) {
            List<Move> firstMoves = player.getStrategy().makeFirstMoves(engineHouse);


        }
    }

    private void dealBricks() throws GameIsBrokenException {
        try {

            //Deal appropriate number of bricks
            final int bricksToDeal = playersToBricksMap.get(players.size());
            for (int i = 0; i < bricksToDeal; i++) {
                for (Player player : players) {
                    new DrawBrick().executeMove(player, this);
                }
            }

            //Make sure every player has a valid starting brick
            List<Player> nonReadyPlayers = new ArrayList<>(players);
            while (nonReadyPlayers.size() > 0) {
                nonReadyPlayers = nonReadyPlayers.stream()
                        .filter(player -> player.getAntiCheat().getVerificationDominoes().stream().noneMatch(brick -> brick.hasValue(roundNumber)))
                        .collect(Collectors.toList());
                for (Player player : nonReadyPlayers) {
                    new DrawBrick().executeMove(player, this);
                }
            }

        } catch (OutOfBricksException e) {
            //If this happens here, something is broken..
            throw new GameIsBrokenException(e.getMessage());
        }
    }

    private void setupRound() throws GameIsBrokenException, EdgeCaseException {

        //Set the starting brick in "the middle"
        try {
            brickPile.removeBrick(new Domino(roundNumber, roundNumber));
        } catch (OutOfBricksException e) {
            //If this happens in this situation, the game is broken..
            throw new GameIsBrokenException(e.getMessage());
        }

        //Deal bricks to players
        try {
            dealBricks();
        } catch (GameIsBrokenException e) {
            //Edge case where at least one player could not get a starting brick. Send a signal to restart the round.
            throw new EdgeCaseException("At least one player could not get a starting brick");
        }
    }

    protected BrickPile getBrickPile() {
        return brickPile;
    }
}
