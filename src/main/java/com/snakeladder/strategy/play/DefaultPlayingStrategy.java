package com.snakeladder.strategy.play;

import java.util.Map;
import java.util.Optional;

import com.snakeladder.config.GameConfig;
import com.snakeladder.model.Game;
import com.snakeladder.model.Player;

public class DefaultPlayingStrategy implements PlayingStrategy{
	public boolean playNext(Game game, int diceMove, String playerId) {
        Player currentPlayer = game.getPlayers()
                .get(playerId);

        int nextPostion = diceMove + currentPlayer.getPosition();

        GameConfig config = game.getConfig();

        if (!validMove(nextPostion, config)) return false;

        nextPostion = checkAndUpdatePosition(nextPostion, config);
        currentPlayer.setPosition(nextPostion);

        return true;
    }


    public boolean isPlayerWinner(Game game, Player player) {
        return Optional.ofNullable(player)
                .map(Player::getPosition)
                .filter(position -> game.getConfig().getEndPoint() == position)
                .isPresent();
    }

    private int checkAndUpdatePosition(int nextPostion, GameConfig config) {
        Map<Integer, Integer> snakes = config.getSnakes();
        Map<Integer, Integer> ladders = config.getLadders();

        while (snakes.containsKey(nextPostion) || ladders.containsKey(nextPostion)) {
            if (snakes.containsKey(nextPostion)) nextPostion = snakes.get(nextPostion);
            else if (ladders.containsKey(nextPostion)) nextPostion = ladders.get(nextPostion);
        }

        return nextPostion;
    }

    private boolean validMove(int nextPostion, GameConfig config) {
        return config.getEndPoint() >= nextPostion && config.getStartPoint() <= nextPostion;
    }
}
