package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPlayerTest{

    @Test
    public void testRPlayerGameCreation(){
        Game g = new RPlayer();
        assertNotNull(g);
    }

   @Test
    public void testHandInit(){
        Game g = new RPlayer();
        g.getCard();
        g.getCard();
        assertEquals(2, g.hand.size());
    }
}
