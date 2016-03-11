package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isaac on 3/10/16.
 */

public class computerTest
{

    @Test
    public void testComputerStart()
    {
        Computer c = new Computer();
        assertEquals(52,c.deck.size());
    }

}
