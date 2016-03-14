package models;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.Serializable;

/*
 *  Created by thai on 03/09/16
 */

public class User extends Player implements Serializable {
    //private ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public static int minimum;
    public int bank, err_no;

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

    public int makeBet(int ante){
        if (ante >= minimum && bank >= ante){
            return ante;  // Valid bet so return the ante
        }
        // Set err_no to 1 if bet is invalid
        err_no = 1;
        return err_no;  // err_no 1 = Invalid bet amount
    }
}
