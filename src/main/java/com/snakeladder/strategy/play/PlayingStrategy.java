package com.snakeladder.strategy.play;

import com.snakeladder.model.Game;
import com.snakeladder.model.Player;

public interface PlayingStrategy {
	boolean playNext(Game game, int diceMove, String playerId);
    boolean isPlayerWinner(Game game, Player player);
}
