package models;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 *  Created by thai on 03/09/16
 */

public class User extends Player{
    //private ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public static int minimum;
    public int bank;

    // Initializing the minimum and bank
    public User(){
        minimum = 2;
        bank = 100;
    }

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
}
