package com.randomQuestions.ASurvivalGame;

import java.util.ArrayList;

public class Game
{
	private static final int RESOURCE_LOCATION = 5000;

	private Hero hero;
	private ArrayList<Enemy> enemies;
	private boolean isDead = false;

	public Game()
	{
	}

	public void startGame()
	{
		initiateCharacters();
		System.out.println("Hero started journey with " + hero.getCurrentHp() + " HP!");

		for (int position = 0; position < RESOURCE_LOCATION; position++)
		{
			if (enemies.size() != 0)
			{
				if (position == enemies.get(0).getPosition())
				{
					fight();
					if (isDead)
					{
						break;
					}
					else
					{
						System.out.println("Hero defeated " + enemies.get(0).getName() + " with " + hero.getCurrentHp()
						+ " HP remaining!");
						enemies.remove(0);
					}
				}
			}
		}
		if (!isDead)
		{
			System.out.println("Hero Survived!");
		}
		else
		{
			System.out.println("Killed by " + enemies.get(0).getName() + " with its " + enemies.get(0).getCurrentHp() + " HP remaining!");
			System.out.println("Game over!");
		}

	}

	private void fight()
	{
		int heroHp = hero.getCurrentHp();
		int heroAtk = hero.getBaseAttack();
		int monHp = enemies.get(0).getCurrentHp();
		int monAtk = enemies.get(0).getBaseAttack();

		while (heroHp > 0 && monHp > 0)
		{
			heroHp -= monAtk;
			monHp -= heroAtk;
		}

		if (heroHp <= 0)
		{
			isDead = true;
		}

		hero.setCurrentHp(heroHp);
		enemies.get(0).setCurrentHp(monHp);
	}

	private void initiateCharacters()
	{
		Enemy.summon(Characters.ZOMBIE, 1681);
		Enemy.summon(Characters.BUG, 276);
		Enemy.summon(Characters.BUG, 489);
		Enemy.summon(Characters.LION, 1527);
		Enemy.summon(Characters.LION, 2865);
		Enemy.summon(Characters.ZOMBIE, 3523);
		this.enemies = Enemy.getEnemies();
		this.hero = Hero.getHero();

	}

}
