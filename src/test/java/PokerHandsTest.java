import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandsTest {

    @Test
    public void should_return_player2_win_when_given_cards_H1_H2_H3_H4_ST_and_C1_C2_C3_C4_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H5 H2 H3 H4 ST";
        String player2Card = "C5 C2 C3 C4 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_given_cards_C6_C2_C3_C5_SA_and_H5_H2_H3_H4_CA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "C6 C2 C3 C5 SA";
        String player2Card = "H5 H2 H3 H4 CA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_draw_when_given_cards_H4_H2_H3_H5_CA_and_C4_C2_C3_C5_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H4 H2 H3 H5 CA";
        String player2Card = "C4 C2 C3 C5 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("draw", result);
    }

    @Test
    public void should_return_player1_win_when_given_cards_H2_S2_H3_H4_CA_and_C4_C2_C3_C5_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H2 S2 H3 H4 CA";
        String player2Card = "C4 C2 C3 C5 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_player2_win_when_given_cards_H2_S2_H3_H6_CA_and_D5_C2_C3_C5_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H2 S2 H3 H6 CA";
        String player2Card = "D5 C2 C3 C5 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_draw_when_given_cards_H2_S2_H3_H4_CA_and_C2_D2_C3_C4_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H2 S2 H3 H4 CA";
        String player2Card = "C2 D2 C3 C4 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("draw", result);
    }

    @Test
    public void should_return_draw_when_given_cards_H2_S2_H3_H5_CA_and_C2_D2_C3_C4_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H2 S2 H3 H5 CA";
        String player2Card = "C2 D2 C3 C4 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player1 win", result);

    }

    @Test
    public void should_return_draw_when_given_cards_C2_D2_C3_C4_SA_and_H2_S2_H3_D3_CA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "C2 D2 C3 C4 SA";
        String player2Card = "H2 S2 H3 D3 CA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_given_cards_H3_S3_H5_D5_CA_and_C2_D2_C5_S5_SA() {
        PokerHands pokerHands = new PokerHands();
        String player1Card = "H3 S3 H5 D5 CA";
        String player2Card = "C2 D2 C5 S5 SA";
        String result = pokerHands.compareTwoCards(player1Card, player2Card);
        Assert.assertEquals("player1 win", result);
    }
}