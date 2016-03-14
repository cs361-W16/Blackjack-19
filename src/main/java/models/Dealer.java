package models;


import java.io.Serializable;
import java.util.ArrayList;


public class Dealer extends Person implements Serializable{


	//inherit from constructor
	public Dealer(){
		super();
	}


	//set the bet to what the dealer now wants
	public void makeBet(int newBet)
	{
		this.bet = newBet;

	}


}
