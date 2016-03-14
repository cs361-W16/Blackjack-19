package models;

import org.h2.command.ddl.DeallocateProcedure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
* Created by IStallcup on 2/27/16.
*/


//abstract class
public class Game implements Serializable{
    // Declaring a heck ton of bools to keep track of game status
    public boolean invalidMove;
    public int playerWon;
    public User user;
    // public Dealer dealer; // Class has not been merged yet

	Random rnd = new Random();  // generating random numbers (to deal out), so we don't need a shuffle function

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();

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

    public int turnResults(){
        /* Calculating the turn's results to return the appropriate values
            * 1 = user won
            * 2 = dealer won
            * 3 = game was tied
        */
        if (user.calcScore(user.hand) > 21){ // User busts
            playerWon = 2;
        }
        else if (dealer.calcScore(dealer.hand) > 21){ // Dealer busts
            playerWon = 1;
        }
        else if (user.calcScore(user.hand) > dealer.calcScore(dealer.hand)){ // User wins
            playerWon = 1;
        }
        else if (user.calcScore(user.hand) < dealer.calcScore(dealer.hand)){ // Dealer wins
            playerWon = 2;
        }
        else{  // User and dealer have the same score
            playerWon = 3;
        }
        return playerWon;
    }

    public void dealNewGame(int ante){
        if (playerWon == 3){
            user.empty_hand();
            //dealer.empty_hand();
        }else if (playerWon == 1){
            user.winBet(ante);
            user.empty_hand();
            //dealer.empty_hand();
        }else{  // else dealer won the last hand
            user.loseBet(ante);
            user.empty_hand();
            //dealer.empty_hand();
        }
        // Call a function that deals a new game??
    }

    //public void userTurn(){
    //}

    public void hit(){

    }

    public void stay(){ // User's turn ends, dealer's turn starts

    }

    public void split() {
        if (user.hand.get(0).getValue() == user.hand.get(1).getValue()) {
            java.util.List<Card> userHand1 = new ArrayList<>();
            java.util.List<Card> userHand2 = new ArrayList<>();

            userHand1.add(user.hand.get(0));
            userHand2.add(user.hand.get(1));
        }else{
            invalidMove = true;
        }
    }

	public Game()
	{
		this.buildDeck();
	}
}
