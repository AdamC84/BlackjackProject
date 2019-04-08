package com.skillsdistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Dealer;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Player;

public class BlackjackImpl {
	Hand hand;
	Deck deck;
	Player player;
	Dealer dealer;
	public Scanner kb = new Scanner(System.in);

	public void launch() {
		player = new Player();
		dealer = new Dealer();
		hand = new Hand();
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
		boolean gamePwr = true;
		int playerHandValue = 0;
		int dealerHandValue = 0;
		Card cardDealt = null;
		do {

			deck.addCardsToDeck();
			deck.checkDeckSize();
			deck.shuffleCards();
			for (int i = 0; i < 2; i++) {
				cardDealt = deck.dealCard(1);
				player.addCardtoHand(cardDealt);
			}
			if (player.getHand().getHandValue() == 21) {
				System.out.println("You win!");
				System.out.println("Would you like to play again(y/n)?");
				String choice = kb.next();
				player.getHand().clearHand();
				dealer.getHand().clearHand();
				if (choice.equalsIgnoreCase("n")) {
					System.out.println("Bye");
					gamePwr = false;
				}
			}
			for (int i = 0; i < 2; i++) {
				cardDealt = deck.dealCard(1);
				dealer.addCardtoHand(cardDealt);
			}
			if (dealer.getHand().getHandValue() == 21) {
				System.out.println("Dealer wins");
				System.out.println("Would you like to play again(y/n)?");
				String choice = kb.next();
				player.getHand().clearHand();
				dealer.getHand().clearHand();
				if (choice.equalsIgnoreCase("n")) {
					System.out.println("Bye");
					gamePwr = false;
				}
			}
			playerHandValue = playersHand();
			dealerHandValue = dealersHand();
			String winStatus = checkForWin(playerHandValue, dealerHandValue);
			System.out.println(winStatus);

			System.out.println("Would you like to play again(y/n)?");
			String choice = kb.next();
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Bye");
				gamePwr = false;
			}

		} while (gamePwr);
	}

	public int playersHand() {
		boolean game = true;
		String playerChoice = "";

		player.displayHand();
		dealer.displayHand();
		do {
			System.out.println("Would you like to hit or stand (H/S)?");
			playerChoice = kb.next();

			if (playerChoice.equalsIgnoreCase("H")) {
				player.addCardtoHand(deck.dealCard(1));
				player.displayHand();
			} else if (playerChoice.equalsIgnoreCase("s")) {

				game = false;
				return player.getHand().getHandValue();
			}
			if (player.getHand().getHandValue() > 21) {
				System.out.println("You've busted");
				game = false;
				return 0;

			}

		} while (game);
		return player.getHand().getHandValue();

	}

	public int dealersHand() {
		boolean game = true;
		do {
			System.out.println("It is now the dealer's turn.");
			dealer.displayHiddenHand();
			if (dealer.getHand().getHandValue() < 17) {
				System.out.println("Dealer will hit.");
				dealer.addCardtoHand(deck.dealCard(1));
				dealer.displayHiddenHand();
			}
			if (dealer.getHand().getHandValue() > 21) {
				System.out.println("Dealer Busted");
				game = false;
				return 0;
			}
			if (dealer.getHand().getHandValue() >= 17) {
				game = false;
				return dealer.getHand().getHandValue();
			}

		} while (game);
		return dealer.getHand().getHandValue();
	}

	public String checkForWin(int playerHand, int dealerHand) {
		if (playerHand > 21) {
			playerHand = 0;
		}
		if (dealerHand > 21) {
			dealerHand = 0;
		}
		if (playerHand > dealerHand) {
			return "You win";
		} else if (playerHand < dealerHand) {
			return "You lose";
		} else if (playerHand == dealerHand) {
			return "It's a push.";
		}
		return "";
	}
}
