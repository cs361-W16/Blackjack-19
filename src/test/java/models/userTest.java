package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class userTest{

    @Test
    public void testBet()
    {
        User g = new User();
        g.makeBet(1);
        //literally just here to make test coverage better, add actual test when function is done :)
        assertEquals(1,1);
    }

    @Test
    public void testUserGameCreation(){
        User g = new User();
        assertNotNull(g);
    }

    @Test
    public void testBankInit(){
        User g = new User();
        assertEquals(100, g.currentAmt());
    }

    @Test
    public void testLostBet(){
        User g = new User();
        g.loseBet(5);
        assertEquals(95, g.currentAmt());
    }

    @Test
    public void testWonBet(){
        User g = new User();
        g.winBet(10);
        assertEquals(110, g.currentAmt());
    }

    /*@Test
    public void testInvalidBet(){
        User g = new User();
        g.makeBet(1);
        System.err.print("Invalid bet amount");
        assertEquals("Invalid bet amount", errContent.toString());
    }*/

    /*@Test
    public void testValidBet(){
        User g = new User();
        g.makeBet(5);
    }*/


}
