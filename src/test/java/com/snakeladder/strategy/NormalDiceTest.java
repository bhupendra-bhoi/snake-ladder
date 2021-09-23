package com.snakeladder.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.snakeladder.strategy.dice.NormalDice;

class NormalDiceTest {

	@Test
	void testScore() {
		int score = new NormalDice().rollDice();
        assertTrue(score >=1 && score <= 6);
	}

}
