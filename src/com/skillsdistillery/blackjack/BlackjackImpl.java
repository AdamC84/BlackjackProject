package com.skillsdistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Dealer;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Player;

public class BlackjackImpl {
	private Hand hand;
	private Deck deck;
	private Player player;
	private Dealer dealer;
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
		Card cardDealt = null;
		while (gamePwr) {

			deck.addCardsToDeck();
			deck.checkDeckSize();
			deck.shuffleCards();
			for (int i = 0; i < 2; i++) {
				cardDealt = deck.dealCard();
				player.addCardtoHand(cardDealt);
			}
			player.displayHand();
			for (int i = 0; i < 2; i++) {
				cardDealt = deck.dealCard();
				dealer.addCardtoHand(cardDealt);
			}
			dealer.displayHand();
			do {

				if (player.getHand().getHandValue() == 21 || dealer.getHand().getHandValue() == 21) {
//					player.displayHand();
//					dealer.displayHand();
					checkForWin(player.getHand().getHandValue(), dealer.getHand().getHandValue());
					break;
				}
				playersHand();
				if (player.getHand().getHandValue() > 21) {
					break;
				}
				dealersHand();
				checkForWin(player.getHand().getHandValue(), dealer.getHand().getHandValue());

				break;
			} while (true);

			System.out.println("Would you like to play again(y/n)?");
			String choice = kb.next();
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Bye");
				gamePwr = false;
			}

		}
		while (true)
			;

	}

	public int playersHand() {
		boolean game = true;
		String playerChoice = "";

		do {
			System.out.println("Would you like to hit or stand (H/S)?");
			playerChoice = kb.next();

			if (playerChoice.equalsIgnoreCase("H")) {
				player.addCardtoHand(deck.dealCard());
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
				dealer.addCardtoHand(deck.dealCard());
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

	public void checkForWin(int playerHand, int dealerHand) {
		if (dealerHand > 21) {
			dealerHand = 0;
		}
		if (playerHand > dealerHand) {
			System.out.println("You win");
		} else if (playerHand < dealerHand) {
			System.out.println("You lose");
		} else if (playerHand == dealerHand) {
			System.out.println("It's a push.");
		}
	}
}
