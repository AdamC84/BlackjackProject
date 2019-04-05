package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackImpl {
	Hand hand;
	Deck deck;
	Player player;
	Dealer dealer;
	public Scanner kb = new Scanner(System.in);

	public void launch() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		boolean programPwr = true;
		String choice = "";

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$       WELCOM TO BLACKJACK APP         $");
		System.out.println("$      WHERE MONEY DOESN'T MATTER       $");
		System.out.println("$ CAUSE YOU'RE JUST HERE FOR THE BUFFET $");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.print("Would you like to play (yes/no)? ");
		do {
			try {
				choice = kb.next();
				if (choice.equalsIgnoreCase("yes")) {
					playHand();
				} else if (choice.equalsIgnoreCase("no")) {
					System.out.println("Better luck next time.");
					programPwr = false;
				}

			}

			catch (Exception e) {

			}

		} while (programPwr);
	}

	public void playHand() {
		deck.addCardsToDeck();
		deck.checkDeckSize();
		deck.shuffleCards();
		for (int i = 0; i < 2; i++) {
			Card cardDealt = deck.dealCard(1);
			player.addCardtoHand(cardDealt);
		}
		for (int i = 0; i < 2; i++) {
			Card cardDealt = deck.dealCard(1);
			dealer.addCardtoHand(cardDealt);
		}
		playersHand();
		dealersHand();

	}

	public void playersHand() {
		boolean game = true;
		String playerChoice = "";
		int cardTotal = 0;

		player.displayHand();
		do {
			System.out.println("Would you like to hit or stand (H/S)?");
			playerChoice = kb.next();

			if (playerChoice.equalsIgnoreCase("H")) {
				player.addCardtoHand(deck.dealCard(1));
				player.displayHand();
			} else if (playerChoice.equalsIgnoreCase("s")) {

				game = false;
			}
			if (player.getHand().getHandValue() > 21) {
				System.out.println("You've busted");
				game = false;

			}

		} while (game);

	}

//		for (int i = 0; i < 2; i++) {
//			cardDealt = deck.dealCard(1);
//			System.out.println(cardDealt);
//		}
//			playersHand.add(cardDealt);
////		cardTotal += cardDealt.getValueOfCard(cardDealt);
//		cardTotal += hand.getHandValue(cardDealt);
//		System.out.println("Your card total is: " + cardTotal);
//		if (cardTotal > 21) {
//			System.out.println("You've busted!");
//			playerChoice = "S";
//		}
//		else if (cardTotal <= 21) {
//		System.out.println("would you like to hit or stand(H/S)?");
//		playerChoice = kb.next();
//		}

	public void dealersHand() {

		int cardTotal = 0;
		Card cardDealt = null;
		dealer.displayHand();

//		for (int i = 0; i < 2; i++) {
//			cardDealt = deck.dealCard(2);
//			System.out.println(cardDealt);
//		}
//		while (cardTotal <= 17 || playerChoice.equalsIgnoreCase("H"))
//			playersHand.add(cardDealt);
//		cardTotal += hand.getHandValue(cardDealt);
//		System.out.println("The dealer's card total is: " + cardTotal);
//		System.out.println("would you like to hit or stand(H/S)?");
//		playerChoice = kb.next();

	}

}
