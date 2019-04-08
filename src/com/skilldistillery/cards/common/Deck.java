package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() {

	}

	public void addCardsToDeck() {
		Suit[] suit = Suit.values();
		Rank[] rank = Rank.values();
		for (int i = 0; i < suit.length; i++) {
			for (int u = 0; u < rank.length; u++) {
				Card newCard = new Card(suit[i], rank[u]);
				deckOfCards.add(newCard);

			}
		}
	}

	public void checkDeckSize() {
		int cardsInDeck = deckOfCards.size();
		if (cardsInDeck < 10) {
			Suit[] suit = Suit.values();
			Rank[] rank = Rank.values();
			for (int i = 0; i < suit.length; i++) {
				for (int u = 0; u < rank.length; u++) {
					Card newCard = new Card(suit[i], rank[u]);
					deckOfCards.add(newCard);

				}
			}
		}

	}

	public Card dealCard(int numOfCards) {
		Card cardOffDeck = null;
		for (int i = 0; i < numOfCards; i++) {
			cardOffDeck = deckOfCards.remove(0);
		}
		return cardOffDeck;
	}

	public void shuffleCards() {
		Collections.shuffle(deckOfCards);
	}

}
