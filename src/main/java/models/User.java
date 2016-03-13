package models;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 *  Created by thai on 03/09/16
 */

public class User{ //extends playComp{
    /* Betting consists of --
     * Current amount - $$
     * Winnings: increment $$ by bet amount
     * Losses: decrement $$ by bet amount
     * Checking that the bet amount is valid
        * Does it meet the minimum?
        * Does the user have the funds to bet that amount?
     */
    //private ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public static int minimum = 2;
    public int bank = 100; //initialize the bank to have $100

    public int currentAmt(){
        return bank;
    }

    public void loseBet(int ante){
        this.bank -= ante;
    }

    public void winBet(int ante){
        this.bank += ante;
    }

    public void makeBet(int ante){
        if (ante >= minimum && bank >= ante){
            // Call playComp function that checks whether player
            // has won or lost against computer

            // Uncomment this section when new class is
            // implemented (that controls the game)
            /*if (playerWon){ // bool variable
                winBet(ante);
                playerWon = false;
            }
            loseBet(ante);
            compWon = false;*/
        }
        //System.setErr(new PrintStream(errContent));
        System.out.println("Invalid bet amount");
    }

    /* YO ISAAC. ADD THE FOLLOWING CODE TO THE PLAYER CLASS. */
    
    // This function sets the card values
    public int setCardVal(Card card){
        int rank = card.getValue();
        if (rank >= 2 && rank <= 10){ // All those nums
            return rank;
        }else if (rank >= 11 && rank < 15){ // Make those face cards equal 10
            return 10;
        }else{  // Oh look, it's an ace
            return 11;
        }
    }

    // Pass in the hand (list of cards) to calculate the user's score
    public int calcScore(java.util.List<Card> hand){
        int score = 0;  // AKA handscore but who wants to type that
        int highAces = 0; // Aces default to be 11
        int cValue; 

        for (int i = 0; i < hand.size(); i++){
            cValue = setCardVal(hand.get(i));
            if (cValue == 11){
                highAces++; // Keep track of the number of (high) aces
            }
            score += cValue;  // Calulate the current score
        }

        if (score > 21 && highAces >= 1){
            score -= 10; // subtract 10 - the ace's value changes from 11 to 1
            highAces -= 1;
        }
        return score; // Return the score for this player's turn
    }
}
