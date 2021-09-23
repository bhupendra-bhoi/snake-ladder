package com.snakeladder.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testInitialPositionZero() {
		Player player = new Player("John");
		assertEquals(player.getPosition(), 0);;
	}

}
