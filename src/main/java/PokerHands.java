import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokerHands {

    public String compareTwoCards(String player1Card, String player2Card) {
        List<Integer> cards1 = conversionCard(player1Card);
        List<Integer> cards2 = conversionCard(player2Card);
        return cards1.get(4)>cards2.get(4)?"player1 win" : "player2 win";
    }

    public List<Integer> conversionCard(String cards){
        ArrayList<Integer> result = new ArrayList<>();
        String[] cardList = cards.split(" ");
        for(String card : cardList){
            switch (card.charAt(1)){
                case '2':
                    result.add(2);
                    break;
                case '3':
                    result.add(3);
                    break;
                case '4':
                    result.add(4);
                    break;
                case '5':
                    result.add(5);
                    break;
                case '6':
                    result.add(6);
                    break;
                case '7':
                    result.add(7);
                    break;
                case '8':
                    result.add(8);
                    break;
                case '9':
                    result.add(9);
                    break;
                case 'T':
                    result.add(10);
                    break;
                case 'J':
                    result.add(11);
                    break;
                case 'Q':
                    result.add(12);
                    break;
                case 'K':
                    result.add(13);
                    break;
                case 'A':
                    result.add(14);
                    break;
            }
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return integer2 - integer1;
            }
        });
        return result;
    }

}
