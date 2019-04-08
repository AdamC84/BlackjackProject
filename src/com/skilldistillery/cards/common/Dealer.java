package com.skilldistillery.cards.common;

import com.skillsdistillery.blackjack.BlackjackHand;

public class Dealer {

	private BlackjackHand hand;

	public Dealer() {
		hand = new BlackjackHand();
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	public void displayHand() {
		System.out.println("The dealer's hand is " + hand.getCards().get(0));
		System.out.println();
		System.out.println("*************");
		System.out.println("*Hidden Card*");
		System.out.println("*************");
	}

	public void displayHiddenHand() {
		System.out.println("Dealers hidden card was " + hand.getCards().get(1));
		System.out.println("Dealer's cards are:");
		for (int i = 0; i < hand.getCards().size(); i++) {
			System.out.println();
			System.out.println(hand.getCards().get(i));
			System.out.println();
		}
		System.out.println("Dealer's hand total is :" + hand.getHandValue());
	}

	public void addCardtoHand(Card card) {
		hand.getCards().add(card);
	}

	public BlackjackHand getHand() {
		return hand;
	}

}
