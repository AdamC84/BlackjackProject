package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();

	public Hand() {

	}

	public int getHandValue() {
		int handTotal = 0;
		for (Card card : hand) {
			handTotal += card.getValueOfCard();

		}

		return handTotal;
	}

	public void addCard() {

	}

	public void clearHand() {
	hand = new ArrayList<>();

	}

	public List<Card> getCards() {
		return hand;
	}

}
