package models;

import java.util.ArrayList;

public abstract class Player
{
    //create the hand for each player?
    public java.util.List</*card type goes here*/Integer> hand = new ArrayList<>();

    public int score;

    public void getScore()
    {
        score = 0; //zero score to reset it
        for (int i = 0; i < hand.size(); i++)
        {
            score += hand.get(i);
        }
    }
}
