package com.snakeladder.printer;

import com.snakeladder.model.Player;

public interface GamePrinter {
	void printPlayerMoves(Player player, int lastPosition, int diceMove);
    void printPlayerWin(Player player);
}
