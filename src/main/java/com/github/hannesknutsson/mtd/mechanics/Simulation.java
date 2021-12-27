package com.github.hannesknutsson.mtd.mechanics;

import com.github.hannesknutsson.mtd.mechanics.errors.GameIsBrokenException;
import com.github.hannesknutsson.mtd.mechanics.errors.InvalidNumberOfPlayersException;

import java.util.*;

public class Simulation {

    private final List<Player> players;
    private final Map<Player, Integer> winMap;
    private final int gamesToPlay;
    private int gamesPlayed;

    public Simulation(final List<Player> players, final int gamesToPlay) throws InvalidNumberOfPlayersException {
        if (players.size() < 2 || players.size() > 8) {
            throw new InvalidNumberOfPlayersException("The number of players must be at least 2 and at most 8.");
        }
        this.players = players;
        Collections.shuffle(this.players);
        this.winMap = new HashMap<>();
        this.players.forEach(player -> winMap.put(player, 0));
        this.gamesToPlay = gamesToPlay;
        this.gamesPlayed = 0;
    }

    public Map<Player, Integer> run() throws GameIsBrokenException {

        //Play the defined number of games
        for (int i = 0; i < this.gamesToPlay; i++) {
            playGame();
        }

        //Check for a winner and play random rounds if there is a tie
        Optional<Player> mostWinsOpt = Optional.empty();
        while (mostWinsOpt.isEmpty()) {
            playGame();
            mostWinsOpt = getWinner();
        }

        return winMap;
    }

    private void playGame() throws GameIsBrokenException {
        Game currentGame = new Game(players);
        Player winner = currentGame.play();
        winMap.put(winner, winMap.get(winner) + 1);
        gamesPlayed++;
    }

    public Optional<Player> getWinner() {
        Optional<Player> winner = Optional.empty();
        int mostWins = 0;
        for (Player player : players) {
            final int playerWins = winMap.get(player);
            if (playerWins > mostWins) {
                mostWins = playerWins;
                winner = Optional.of(player);
            } else if (playerWins == mostWins) {
                //There is a tie..
                winner = Optional.empty();
            }
        }
        return winner;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}
