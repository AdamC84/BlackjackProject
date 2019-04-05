package com.skilldistillery.cards.common;

public class BlackjackApp {
	BlackjackImpl bji = new BlackjackImpl();

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}

	private void run() {
		bji.launch();

	}

}
