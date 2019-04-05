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

//	public void clearHand() {
//		for (int i = 0; i < dealerHand.size(); i++) {
//			dealerHand.remove(0);
//		}
//		for (int i = 0; i < playersHand.size(); i++) {
//			playersHand.remove(0);
//		}
//
//	}

	public List<Card> getCards() {
		return hand;
	}

}
