package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), CLUBS("Clubs"), SPADES("Spades"), DIAMONDS("Diamonds");

	Suit(String n){
		name = n;
	}

	final private String name;
	

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
