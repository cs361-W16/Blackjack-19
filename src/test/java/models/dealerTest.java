package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isaac on 3/13/16.
 */
public class dealerTest
{
    @Test
    public void dealCustomCardToDealerTest()
    {
        Game g = new Game();
        g.addCustomCardToDealer();
        assertEquals(g.dealer.hand.get(0).getSuit(),Suit.Spades);
    }

    @Test
    public void dealCardToDealerTest()
    {
        Game g = new Game();
        g.dealCardToDealer();
        assertEquals(g.dealer.hand.size(),1);
    }
}
