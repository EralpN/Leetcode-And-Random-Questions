package com.randomQuestions.ASurvivalGame;

public enum Characters
{
	HERO("Hero", 1000, 10),
	BUG("Bug", 50, 2),
	LION("Lion", 100, 15),
	ZOMBIE("Zombie", 300, 7);
	
	private String name;
	private int baseHp;
	private int baseAttack;
	
	private Characters(String name, int baseHp, int baseAttack)
	{
		this.name = name;
		this.baseHp = baseHp;
		this.baseAttack = baseAttack;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBaseHp()
	{
		return this.baseHp;
	}
	
	public int getBaseAttack()
	{
		return this.baseAttack;
	}
}
