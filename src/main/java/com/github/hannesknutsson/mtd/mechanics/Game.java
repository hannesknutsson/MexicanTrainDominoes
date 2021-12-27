package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.EdgeCaseException;
import com.github.hannesknutsson.mtd.mechanics.errors.GameIsBrokenException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Game {

    private final List<Player> players;
    private final Map<Player, Integer> scoreMap;

    public Game(final List<Player> players) {
        this.players = players;
        this.scoreMap = new HashMap<>();
        this.players.forEach(player -> this.scoreMap.put(player, 0));
    }

    public Player play() throws GameIsBrokenException {

        //Play the normal 13 rounds
        for (int roundNumber = 13; roundNumber >= 0; roundNumber--) {
            playRound(roundNumber);
        }

        //Check for a winner and play random rounds if there is a tie
        Optional<Player> winnerOpt = Optional.empty();
        while (winnerOpt.isEmpty()) {
            final int randomRound = (int) (Math.random() * 13);
            playRound(randomRound);
            winnerOpt = getWinner();
        }

        //Get the winner and print the result
        Player winner = winnerOpt.get();
        System.out.println("Player " + winner.getName() + " won the game with only " + scoreMap.get(winner) + " points! Very nice!");

        return winner;
    }

    private void playRound(final int roundNumber) throws GameIsBrokenException {
        rotateStartingPlayer();

        Round currentRound = new Round(roundNumber, this.players);
        Map<Strategy, Integer> roundScores = new HashMap<>();

        boolean replayRound;
        do {
            try {
                roundScores = currentRound.play();
                replayRound = false;
            } catch (EdgeCaseException e) {
                replayRound = true;
            }
        } while (replayRound);

        for (Player player : this.players) {
            scoreMap.put(player, scoreMap.get(player) + roundScores.get(player));
        }
    }

    private void rotateStartingPlayer() {
        Player currentFirstPlayer = players.remove(0);
        players.add(currentFirstPlayer);
    }

    private Optional<Player> getWinner() {
        Optional<Player> winner = Optional.empty();
        int lowestScore = Integer.MAX_VALUE;
        for (Player player : players) {
            final int playerScore = scoreMap.get(player);
            if (playerScore < lowestScore) {
                lowestScore = playerScore;
                winner = Optional.of(player);
            } else if (playerScore == lowestScore) {
                //There is a tie..
                winner = Optional.empty();
            }
        }
        return winner;
    }
}
