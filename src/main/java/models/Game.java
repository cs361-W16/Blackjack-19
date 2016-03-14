package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public class Game {

	Random rnd = new Random();

	Dealer dealer;
	User user;

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();

	boolean userWon = false;
	boolean dealerWon = false;

	//use int as placeholder as the suit of the card doesn't matter in blackjack

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

	public void addCustomCardToUser()
	{
		Card addMe = new Card();
		addMe.setCard(Suit.Spades,2);
		user.hand.add(addMe);
	}

	public void addCustomCardToDealer()
	{
		Card addMe = new Card();
		addMe.setCard(Suit.Spades,15); //different to test who wins
		dealer.hand.add(addMe);
	}


	public void dealCardToUser()
	{
		user.hand.add(dealCard());
		if (user.calcScore(user.hand) > 21)
		{
			userWon = false;
			dealerWon = true;
			//set flag to not play dealer game?
		}
	}

	public void dealCardToDealer()
	{
		dealer.hand.add(dealCard());
		if (dealer.calcScore(dealer.hand) > 21)
		{
			userWon = true;
			dealerWon = false;
		}
	}

	public void whoWon()
	{
		int dealerScore = dealer.calcScore(dealer.hand);
		int userScore = user.calcScore(user.hand);
		if (dealerScore > userScore)
			dealerWon = true;
		else if (dealerScore != userScore)
			userWon = true;
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
		dealer = new Dealer();
		user = new User();
		dealerWon = false;
		userWon = false;
	}
}
