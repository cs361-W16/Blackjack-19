package models;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by isaac on 3/9/16.
 */
public class gameTest
{

    @Test
    public void testGameStart()

    {
        Game g = new Game();
        //when Game is abstract, replace with instatiation of actual class
        assert(g.deck.size() == 52);
    }

    @Test
    public void testGetCardDecrementsSize()
    {
        Game g = new Game();
        //when Game is abstract, replace with instatiation of actual class
        /*Card*/ Integer card1 = g.getCard();
        assert(g.deck.size() == 51);
    }

    @Test
    public void testDealTwo()
    {
        Game g = new Game();
        g.getCard();
        g.getCard();
        assert(g.hand.size() == 2);
    }


}
