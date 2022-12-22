package com.randomQuestions.ASurvivalGame;

public abstract class Entity {
	private int currentHp;
	private Characters character;

	public Entity(Characters character) {
		super();
		this.character = character;
		this.currentHp = character.getBaseHp();
	}

	public int getCurrentHp() {
		return this.currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public String getName() {
		return this.character.getName();
	}

	public int getBaseHp() {
		return this.character.getBaseHp();
	}

	public int getBaseAttack() {
		return this.character.getBaseAttack();
	}

}
