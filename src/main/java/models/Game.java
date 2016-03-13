package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public class Game {

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();
	//use int as placeholder as the suit of the card doesn't matter in blackjack

	public void buildDeck()
	{
		Card addMe = null;
		for (int cNum = 2; cNum < 15; cNum++)
		{
			addMe.setCard(Suit.Hearts,cNum);
			deck.add(addMe);
			addMe.setCard(Suit.Spades,cNum);
			deck.add(addMe);
			addMe.setCard(Suit.Clubs,cNum);
			deck.add(addMe);
			addMe.setCard(Suit.Diamonds,cNum);
			deck.add(addMe);
		}
	}

	public Game()
	{
		this.buildDeck();
	}
}
