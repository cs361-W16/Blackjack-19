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
}
