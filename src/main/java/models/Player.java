package models;


import java.util.ArrayList;
import java.io.Serializable;

/**
 * Created by isaac on 3/12/16.
 */
public abstract class Player implements Serializable
{
    //"oops" not in the constructor
    public java.util.List<Card> hand = new ArrayList<>();

    public int score;

    public void empty_hand()
    {
        int hand_size = hand.size();
        for (int i = 0; i < hand_size; i++)
            hand.remove(0);
    }

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
    public int calcScore(java.util.List<Card> hand) {
        int score = 0;  // AKA handscore but who wants to type that
        int highAces = 0; // Aces default to be 11
        int cValue;

        for (int i = 0; i < hand.size(); i++) {
            cValue = setCardVal(hand.get(i));
            if (cValue == 11) {
                highAces++; // Keep track of the number of (high) aces
            }
            score += cValue;  // Calculate the current score
        }

        if (score > 21 && highAces >= 1) {
            score -= 10; // subtract 10 - the ace's value changes from 11 to 1
            highAces -= 1;
        }
        return score; // Return the score for this player's turn
    }

    public Player()
    {
        score = 0;
    }
}
