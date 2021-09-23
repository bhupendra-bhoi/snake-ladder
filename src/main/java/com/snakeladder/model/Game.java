package com.snakeladder.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.snakeladder.config.GameConfig;
import com.snakeladder.printer.ConsoleGamePrinter;
import com.snakeladder.printer.GamePrinter;
import com.snakeladder.strategy.play.DefaultPlayingStrategy;
import com.snakeladder.strategy.play.PlayingStrategy;

public class Game {
	private GameConfig config;
    private Map<String, Player> players;
    private PlayingStrategy playingStrategy;
    private GamePrinter printer;

    Game(GameConfig config, PlayingStrategy playingStrategy, List<Player> playerList, GamePrinter printer) {
        this.config = config;
        this.playingStrategy = playingStrategy;
        this.players = playerList.stream()
                .collect(Collectors.toMap(Player::getPlayerId, Function.identity()));
        this.printer = printer;
    }

    public Game(GameConfig config, List<Player> playerList) {
        this(config, new DefaultPlayingStrategy(), playerList, new ConsoleGamePrinter());
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public GameConfig getConfig() {
        return config;
    }

    public boolean isComplete() {
        return getPlayers()
                .values()
                .stream()
                .filter(player -> player.getPosition() == getConfig().getEndPoint())
                .findFirst()
                .isPresent();
    }

    public boolean playNext(String playerId) {
        Player currentPlayer = players.get(playerId);

        if (currentPlayer == null || isPlayerWinner(currentPlayer)) return false;

        int lastValidPosition = currentPlayer.getPosition();

        int diceMove = getConfig().getDices()
                .stream()
                .map(dice -> dice.rollDice())
                .reduce(Integer::sum)
                .orElse(0);

        boolean validMove = playingStrategy.playNext(this, diceMove, playerId);
        if (validMove) printer.printPlayerMoves(currentPlayer, lastValidPosition, diceMove);

        if (isPlayerWinner(currentPlayer)) printer.printPlayerWin(currentPlayer);

        return validMove;
    }

    public boolean isPlayerWinner(Player player) {
        return playingStrategy.isPlayerWinner(this, player);
    }
}
