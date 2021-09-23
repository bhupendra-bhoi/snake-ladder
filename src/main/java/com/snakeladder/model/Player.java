package com.snakeladder.model;

import java.util.UUID;

public class Player {
	private String playerId;
	private String name;
	private int position;
	public Player(String name) {
		this.playerId = UUID.randomUUID().toString();
		this.position = 0;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
        this.position = position;
    }
	public String getPlayerId() {
		return playerId;
	}
}
