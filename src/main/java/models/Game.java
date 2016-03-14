package models;

import java.util.Collections;
import java.util.ArrayList;		//game is an array of arrays
import java.util.Random;		
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



//game class - has a card
//player has a game



public class Game implements Serializable{


	//fields

	public java.util.List<Card> deck;		//initialize an array of cards called Deck

	public Player a_player;		
	public Dealer a_dealer;




	//methods
	public Game(){
		this.player = new player(1);
		this.dealer = new dealer();
		this.deck = new ArrayList<>();
		buildDeck();


	}



	//build a deck of cards
	public void build()
	{
		for(int i =1; i<15;++i)
		{
			deck.add(new Card(i,Suit.Clubs));
			deck.add(new Card(i,Suit.Hearts));
			deck.add(new Card(i,Suit.Diamonds));
			deck.add(new Card(i,Suit.Spades));

	  	}
	}

public class Game {

	Random rnd = new Random();

	//create the deck list
	public java.util.List<Card> deck = new ArrayList<>();

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


			//group 13
			public void dealer(int i)
			{
				if(i == 1) {
					//Do first hand
					if (player.getCount() == 21) {
						player.winBlackJack(1);
						endHand("You got Blackjack!");
					} else {
						//if you need to split
						if(hasSplit && secondStand){
							//clear your hands and shuffle
							dealer.emptyHand(deck);
							shuffle();
						}


						dealer.setHand(deal(dealer.getHand(), 2));
						while (dealer.getCount() < 17) {
							dealer.setHand(deal(dealer.getHand(), 1));
						}
						if (dealer.getCount() > 21) {
							player.win(1);
							endHand("Dealer busts. You win!");
						} else if (dealer.getCount() == player.getCount()) {
							//Start new hand with same bet
							errorFlag = false;
							userMessage = "Tie! New Hand";
							againDisabled = true;
							dealDisabled = false;
							hitDisabled = true;
							splitDisabled = true;
							standDisabled = true;
							doubleDisabled = true;
							bettingDisabled = true;
							previousTie = true;
						} else if (dealer.getCount() > player.getCount()) {
							endHand("Dealer Wins");
						} else {
							endHand("You win!");
							player.win(1);
						}
						standDisabled = true;
					}
				}else if(i == 2) {
					//Do second Hand
					if (player.getSecondCount() == 21 && player.getSecondHand().size() == 2) {
						player.winBlackJack(2);
						endSecondHand("You got Blackjack!");
					} else {
						if(firstStand){
							dealer.emptyHand(deck);
							shuffle();
						}
						dealer.setHand(deal(dealer.getHand(), 2));
						while (dealer.getCount() < 17) {
							dealer.setHand(deal(dealer.getHand(), 1));
						}
						if (dealer.getCount() > 21) {
							player.win(2);
							endSecondHand("Dealer busts. You win!");
						} else if (dealer.getCount() > player.getCount()) {
							endSecondHand("Dealer Wins");
						} else {
							endSecondHand("You win!");
							player.win(2);
						}
					}
				}




			}





			//shuffle
			public void shuffle()
			{
				long seed = System.nanoTime();
				Collections.shuffle(deck,new Random(seed));
			}





			//function adds a certain number of cards to a specific hand of cards
			public void deal (java.util.List<Card>hand,int num)
			{
				//do this how many every times
				for(int i=0;i<num;++i)
				{

					hand.add(removeTop(deck));		//add to the hand by removing the top card of the deck

				}
			}



			public Card removeTop(java.util.List<Card> hand)
			{
				return hand.remove(hand.size()-1);		//remove top card of hand

			}



}
