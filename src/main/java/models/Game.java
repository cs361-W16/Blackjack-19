package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//abstract class
public class Game {


	Random rnd = new Random();

	Dealer d = new Dealer();

	//create the deck list
	public java.util.List</*card type goes here*/Integer> deck = new ArrayList<>();
	//use int as placeholder as the suit of the card doesn't matter in blackjack

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

	public void dealCustomDealer(Integer card1)
	{
		d.hand.add(card1);
	}

	public void dealTwoDealer()
	{
		d.hand.add(getCard());
		d.hand.add(getCard());
	}

	public Game()
	{
		this.buildDeck();
	}

	public /*Card*/ Integer getCard()
	{
		int removedIdx = rnd.nextInt(deck.size());
		/*Card*/ Integer removedCard = deck.get(removedIdx);
		deck.remove(removedIdx);
		return removedCard;
	}
}
