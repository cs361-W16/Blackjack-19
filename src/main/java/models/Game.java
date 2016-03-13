package models;

import java.util.ArrayList;
import java.util.Random;

/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public class Game {

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();

	Random rnd = new Random();

	public void buildDeck()
	{
		Card addMe = new Card();
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

	//function to get card from the deck, remove it from deck, return it
	public Card dealCard()
	{
		int removedIdx = rnd.nextInt(deck.size());
		Card removedCard = deck.get(removedIdx);
		deck.remove(removedIdx);
		return removedCard;
	}

	public Game()
	{
		this.buildDeck();
	}
}
