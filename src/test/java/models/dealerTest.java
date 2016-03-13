package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class dealerTest
{
    @Test
    public void testDealerInit()
    {
        Game g = new Game();
        g.dealTwoDealer();
        assertEquals(2, g.d.hand.size());
    }

    @Test
    public void testDealerAddCard()
    {
        Game g = new Game();
        Integer card1 = 2;
        g.dealCustomDealer(card1);
        assertEquals(g.d.hand.get(0),card1);
    }

    @Test
    public void testGetScore()
    {
        Game g = new Game();
        Integer card1 = 2;
        g.dealCustomDealer(card1);
        g.d.getScore();
        assertEquals(g.d.score,2);
    }
}