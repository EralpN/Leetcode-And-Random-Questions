package com.randomQuestions.ASurvivalGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Enemy extends Entity {
	private static ArrayList<Enemy> enemies = new ArrayList<>();
	private int position;

	private Enemy(Characters character, int position) {
		super(character);
		this.position = position;
		enemies.add(this);
		sortEnemies();
	}

	public static ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public int getPosition() {
		return this.position;
	}

	public static void summon(Characters character, int position) {
		new Enemy(character, position);
	}

	private void sortEnemies() {
		Collections.sort(enemies, new Comparator<Enemy>() {
			public int compare(Enemy first, Enemy second) {
				return Integer.compare(first.getPosition(), second.getPosition());
			}
		});
	}
}
