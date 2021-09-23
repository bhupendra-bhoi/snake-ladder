package com.snakeladder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.snakeladder.config.GameConfig;
import com.snakeladder.generator.GameGenerator;
import com.snakeladder.model.Game;
import com.snakeladder.model.Player;
import com.snakeladder.strategy.dice.CrookedDice;
import com.snakeladder.strategy.dice.Dice;
import com.snakeladder.strategy.dice.NormalDice;

public class SnakeLadderApplication {

	public static void main(String[] args) {
		//Dice normalDice = new NormalDice();
		Dice crookedDice = new CrookedDice();
        final int MAX_NO_OF_RUNS = 10;
        
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14, 7);

        Map<Integer, Integer> ladders = new HashMap<>();

        GameConfig config = new GameConfig(100, 0, snakes, ladders, Arrays.asList(crookedDice));

        Player firstPlayer = new Player("John");

        Game snakeLadderGame = GameGenerator.generateGame(config, Arrays.asList(firstPlayer));
        
        int noOfRuns = 0;

        while (!snakeLadderGame.isComplete() && noOfRuns++ < MAX_NO_OF_RUNS) {
            for (Player player : snakeLadderGame.getPlayers().values()) {
                snakeLadderGame.playNext(player.getPlayerId());
                if (snakeLadderGame.isComplete()) break;
            }
        }
	}

}
