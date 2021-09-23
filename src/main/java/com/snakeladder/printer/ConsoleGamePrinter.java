package com.snakeladder.printer;

import com.snakeladder.model.Player;

public class ConsoleGamePrinter implements GamePrinter {

	private String MOVE_PRINT_TEMPLATE = "%s rolled %s and moved from %s to %s";
    private String WINNER_PRINT_TEMPLATE = "%s is the Winner";

    @Override
    public void printPlayerMoves(Player player, int lastPosition, int diceMove) {
        System.out.println(String.format(MOVE_PRINT_TEMPLATE, player.getName(), diceMove, lastPosition, player.getPosition()));
    }

    @Override
    public void printPlayerWin(Player player) {
        System.out.println(String.format(WINNER_PRINT_TEMPLATE, player.getName()));
    }

}
