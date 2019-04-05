package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private BlackjackHand hand;
	
	public Dealer() {
		hand = new BlackjackHand();
	}

	public void displayHand() {
			System.out.println("The dealer's hand is " + hand.getCards());
			System.out.println();
			System.out.println("*************");
			System.out.println("*Hidden Card*");
			System.out.println("*************");
		}

	

	public void displayHiddenHand() {
		System.out.println("Dealers hidden card was " + hand.getCards().get(0));

	}

	public void addCardtoHand(Card card) {
		hand.getCards().add(card);
	}

}
