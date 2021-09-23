package com.snakeladder.generator;

import java.util.List;

import com.snakeladder.config.GameConfig;
import com.snakeladder.model.Game;
import com.snakeladder.model.Player;

public class GameGenerator {
	public static Game generateGame(GameConfig gameConfig, List<Player> playerList) {
        Game game = new Game(gameConfig, playerList);
        return game;
    }
}
