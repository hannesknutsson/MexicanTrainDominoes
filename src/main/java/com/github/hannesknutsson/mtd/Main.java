package com.github.hannesknutsson.mtd;

import com.github.hannesknutsson.mtd.mechanics.Player;
import com.github.hannesknutsson.mtd.mechanics.Simulation;
import com.github.hannesknutsson.mtd.mechanics.errors.GameIsBrokenException;
import com.github.hannesknutsson.mtd.mechanics.errors.InvalidNumberOfPlayersException;
import com.github.hannesknutsson.mtd.playerimplementations.hannesknutsson.BasicStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws GameIsBrokenException, InvalidNumberOfPlayersException {

        final List<Player> players = new ArrayList<>();

        players.add(Player.createPlayer(new BasicStrategy()));
        players.add(Player.createPlayer(new BasicStrategy()));
        players.add(Player.createPlayer(new BasicStrategy()));

        final int gamesToPlay = 100;
        Simulation simulation = new Simulation(players, gamesToPlay);

        final Map<Player, Integer> playerWinMap = simulation.run();

        Player winner = simulation.getWinner().orElseThrow(() -> new GameIsBrokenException("It would appear that the shit has hit the fan."));

        System.out.println("Player " + winner.getName() + " won the simulation by clenching " + playerWinMap.get(winner) + " wins out of " + simulation.getGamesPlayed() + " games!");
    }

}
