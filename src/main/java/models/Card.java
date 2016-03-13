package models;

/**
 * Created by isaac on 3/12/16.
 */
public class Card
{
    private Suit suit;
    private int value;
    public boolean faceUp = true;

    //JSON creator?

    public void setCard(Suit inSuit, int inValue)
    {
        value = inValue;
        suit = inSuit;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    public void turnFaceDown()
    {
        faceUp = false;
    }

    public void turnFaceUp()
    {
        faceUp = true;
    }

    public Card()
    {
        suit = Suit.Spades;
        value = 2;
    }
}
