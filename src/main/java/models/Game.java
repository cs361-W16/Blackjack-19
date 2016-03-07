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
	public.java.util.List</*card type goes here*/int> deck = new ArrayList<>();
	//use int as placeholder as the suit of the card doesn't matter in blackjack


	//create the heand for each player?
	public.java.util.List</*card type goes here*/int> hand = new ArrayList<>();

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
}
