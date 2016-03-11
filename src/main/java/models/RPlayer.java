package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 *  Created by thai on 03/09/16
 */

public class RPlayer{ //extends playComp{
    /* Betting consists of --
     * Current amount - $$
     * Winnings: increment $$ by bet amount
     * Losses: decrement $$ by bet amount
     * Checking that the bet amount is valid
        * Does it meet the minimum?
        * Does the user have the funds to bet that amount?
     */
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
                //playerWon = false;
            }
            loseBet(ante);
            //compWon = false;*/
        }
        System.out.println("Invalid bet amount");
    }
}
