package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isaac on 3/9/16.
 */
public class gameTest
{
    @Test
    public void testGameInit()
    {
        Game g = new Game();
        assertEquals(52, g.deck.size());
    }
}
