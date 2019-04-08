package com.skilldistillery.cards.common;

import com.skillsdistillery.blackjack.BlackjackHand;

public class Player {

	private BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();

	}
	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	public void displayHand() {
		System.out.println("Your cards are:");
		for (int i = 0; i < hand.getCards().size(); i++) {
			System.out.println();
			System.out.println(hand.getCards().get(i));
			System.out.println();
		}
		System.out.println("Your hand total is :" + hand.getHandValue());
	}

	public BlackjackHand getHand() {
		return hand;
	}


	public void addCardtoHand(Card card) {
		hand.getCards().add(card);
	}

}
