package models;

import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by isaac on 3/9/16.
 */
public class gameTest
{

    @Test
    public void testGameStart()

    {
        Game g = new Game();
        assert(g.deck.size() == 52);
    }

    @Test
    public void testGetCardDecrementsSize()
    {
        Game g = new Game();
        /*Card*/ Integer card1 = g.getCard();
        assert(g.deck.size() == 51);
    }


}
