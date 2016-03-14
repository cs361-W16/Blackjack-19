package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isaac on 3/9/16.
 */

public class gameTest
{
    @Test
    public void testGameInitDeckSize()
    {
        Game g = new Game();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testPlayGame()
    {
        Game g = new Game();
        g.addCustomCardToDealer();
        g.addCustomCardToUser();
        g.whoWon(5);
        assertTrue(g.dealerWon);
    }

    @Test
    public void testEmptyHand() //has to be here cuz cards must be dealt
    {
        Game g = new Game();
        g.addCustomCardToDealer();
        g.dealer.empty_hand();
        assertEquals(0,g.dealer.hand.size());
    }

    @Test
    public void dealCardToUserTest()
    {
        Game g = new Game();
        g.dealCardToUser();
        assertEquals(g.user.hand.size(),1);
    }

    @Test
    public void dealCustomCardToUserTest()
    {
        Game g = new Game();
        g.addCustomCardToUser();
        assertEquals(g.user.hand.get(0).getSuit(),Suit.Spades);
    }

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

    @Test
    public void dealTwoAces()
    {
        Game g = new Game();
        g.addCustomCardToDealer(); //is an ace
        g.addCustomCardToDealer(); //is an ace
        assertEquals(g.dealer.calcScore(g.dealer.hand),12); //should be 12 not 22
    }

    @Test
    public void testUserBust()
    {
        Game g = new Game();
        for (int i = 0; i < 25; i++)
        {
            g.dealCardToUser();
        }
        assertTrue(g.dealerWon);
        assertFalse(g.userWon);
    }

    @Test
    public void testDealerBust()
    {
        Game g = new Game();
        for (int i = 0; i < 25; i++)
        {
            g.dealCardToDealer();
        }
        assertFalse(g.dealerWon);
        assertTrue(g.userWon);
    }

    @Test
    public void testStay(){
        Game g = new Game();
        User user = new User();
        Dealer dealer = new Dealer();
        g.stay();
        assertTrue(dealer.score >= user.score);
    }

    @Test
    public void testNewTurn(){
        Game g = new Game();
        User user = new User();
        Dealer dealer = new Dealer();
        g.newTurn();
        assertEquals(0, user.hand.size());
        assertEquals(0, dealer.hand.size());
        assertFalse(g.userWon);
        assertFalse(g.dealerWon);
    }
}
