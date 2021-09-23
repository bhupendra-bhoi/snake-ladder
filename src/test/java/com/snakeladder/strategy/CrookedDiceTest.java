package com.snakeladder.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.snakeladder.strategy.dice.CrookedDice;

class CrookedDiceTest {

	@Test
	void testScore() {
		int score = new CrookedDice().rollDice();
        assertEquals(score % 2, 0);;
	}

}
