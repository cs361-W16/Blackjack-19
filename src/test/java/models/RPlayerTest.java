package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPlayerTest{

    @Test
    public void testRPlayerGameCreation(){
        RPlayer g = new RPlayer();
        assertNotNull(g);
    }

    @Test
    public void testBankInit(){
        RPlayer g = new RPlayer();
        assertEquals(100, g.currentAmt());
    }

    @Test
    public void testLostBet(){
        RPlayer g = new RPlayer();
        g.loseBet(5);
        assertEquals(95, g.currentAmt());
    }

    @Test
    public void testWonBet(){
        RPlayer g = new RPlayer();
        g.winBet(10);
        assertEquals(110, g.currentAmt());
    }
}
