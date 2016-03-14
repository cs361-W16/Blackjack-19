package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.Serializable;
/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public class Game implements Serializable {

	Random rnd = new Random();

	public Dealer dealer;
	public User user;

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();

	boolean userWon = false;
	boolean dealerWon = false;

	//use int as placeholder as the suit of the card doesn't matter in blackjack

	public void buildDeck()
	{
		Card addMe = new Card();
		int cardIdx = 0;
		for (int cNum = 2; cNum < 15; cNum++)
		{
			addMe.setCard(Suit.Hearts,cNum);
			deck.add(cardIdx, addMe);
			cardIdx++;
		}
		for (int cNum = 2; cNum < 15; cNum++)
		{
			addMe.setCard(Suit.Spades,cNum);
			deck.add(cardIdx, addMe);
			cardIdx++;
		}
		for (int cNum = 2; cNum < 15; cNum++)
		{
			addMe.setCard(Suit.Diamonds,cNum);
			deck.add(cardIdx, addMe);
			cardIdx++;
		}
		for (int cNum = 2; cNum < 15; cNum++)
		{
			addMe.setCard(Suit.Clubs,cNum);
			deck.add(cardIdx, addMe);
			cardIdx++;
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

	public void whoWon(int ante)
    {
        int dealerScore = dealer.calcScore(dealer.hand);
        int userScore = user.calcScore(user.hand);
        if (dealerScore > userScore){
            dealerWon = true;
            user.loseBet(ante);
        }else if (dealerScore != userScore){
            userWon = true;
            user.winBet(ante);
        }
	}

    // A player choosing to stay is essentially a signal
    // for the dealer's turn to start
    public void stay(){
        /* Calculate what scores the user and dealer currently have
             while the dealer has a smaller hand than the user, continue to hit
             then re-calc/reset the dealerScore */
        int userScore = user.calcScore(user.hand);
        int dealerScore = dealer.calcScore(dealer.hand);
        while (dealerScore < userScore){
            dealCardToDealer();
            dealerScore = dealer.calcScore(dealer.hand);
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

    // Reset hands and win statuses
    public void newTurn(){
        user.empty_hand();
        userWon = false;
        dealer.empty_hand();
        dealerWon = false;
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
