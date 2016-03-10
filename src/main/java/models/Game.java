package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public /*abstract*/ class Game {
	
	//create the deck list
	public java.util.List</*card type goes here*/Integer> deck = new ArrayList<>();
	//use int as placeholder as the suit of the card doesn't matter in blackjack


	//create the hand for each player?
	public java.util.List</*card type goes here*/Integer> hand = new ArrayList<>();

	//random # generator initialization
	Random rnd = new Random();


	public int handScore = 0;

	public void buildDeck()
	{
		for (int cNum = 2; cNum < 15; cNum++)
		{
			deck.add(cNum);
			deck.add(cNum);
			deck.add(cNum);
			deck.add(cNum);
		}
	}

	public Game()
	{
		this.buildDeck();
	}

	//alternative plan: write shuffle, then each time you want a card shuffle the deck, get the last card then shrink
	// the deck array by 1. This kills the card

	//will return the card it chooses
	public /*Card*/ Integer getCard()
	{
		int removedIdx = rnd.nextInt(deck.size());
		/*Card*/ Integer removedCard = deck.get(removedIdx);
		deck.remove(removedIdx);
		return removedCard;
	}
}
