import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandsTest {

    @Test
    public void should_return_player2_win_when_given_cards_H1_H2_H3_H4_ST_and_C1_C2_C3_C4_SA(){
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H5 H2 H3 H4 ST";
        String player2Card = "C5 C2 C3 C4 SA";
        String result = pokerHands.compareTwoCards(player1Card,player2Card);
        Assert.assertEquals("player2 win",result);
    }
}