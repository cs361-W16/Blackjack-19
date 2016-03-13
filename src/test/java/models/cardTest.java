package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isaac on 3/12/16.
 */
public class cardTest
{
    @Test
    public void initCard()
    {
        Card c = new Card();
        c.setCard(Suit.Spades,2);
        assertEquals(Suit.Spades,c.getSuit());
        assertEquals(2,c.getValue());
    }
}
