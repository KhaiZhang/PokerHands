import java.util.*;

public class PokerHands {

    public String compareTwoCards(String player1Card, String player2Card) {
        Map<Integer, Integer> cards1 = conversionCard(player1Card);
        Map<Integer, Integer> cards2 = conversionCard(player2Card);
        String result = "draw";

        if(compareCardMapSize(cards1,cards2) == 0){
            if(cards1.size() == 5){
                result = compareTwoCardWithHighestValue(cards1,cards2);
            }else if(cards1.size() == 4){
                result = compareTwoCardWithPair(cards1,cards2);
            }

        }else {
            System.out.println("mapSize is not equal;");
            result = compareCardMapSize(cards1,cards2) == -1?"player1 win" : "player2 win";
        }

        return result;
    }
    public String compareTwoCardWithHighestValue(Map<Integer, Integer> cards1, Map<Integer, Integer> cards2){
        String result = "draw";
        Iterator<Map.Entry<Integer, Integer>> card1Iterator = cards1.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> card2Iterator = cards2.entrySet().iterator();
        while(card1Iterator.hasNext() && card2Iterator.hasNext()){
            Map.Entry<Integer, Integer> cardEntry1 = card1Iterator.next();
            Map.Entry<Integer, Integer> cardEntry2 = card2Iterator.next();
            System.out.println(cardEntry1.getKey() + "  :  " + cardEntry2.getKey());
            if(cardEntry1.getKey() == cardEntry2.getKey()){
                continue;
            }
            result = cardEntry1.getKey() > cardEntry2.getKey()?"player1 win" : "player2 win";
            break;
        }
        return result;
    }

    public String compareTwoCardWithPair(Map<Integer, Integer> cards1, Map<Integer, Integer> cards2){
        System.out.println("compareTwoCardWithPair");
        String result = "draw";
        Iterator<Map.Entry<Integer, Integer>> card1Iterator = cards1.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> card2Iterator = cards2.entrySet().iterator();
        Integer card1Pair = null;
        Integer card2Pair = null;
        while (card1Iterator.hasNext() && card2Iterator.hasNext()){
            Map.Entry<Integer, Integer> card1 = card1Iterator.next();
            if(card1.getValue() == 2){
                card1Pair = card1.getKey();
            }
            Map.Entry<Integer, Integer> card2 = card2Iterator.next();
            if(card2.getValue() == 2){
                card2Pair = card2.getKey();
            }
            if(card1Pair != null && card2Pair!= null){
                if(card1Pair == card2Pair){
                    result = compareTwoCardWithHighestValue(cards1,cards2);
                    break;
                }
                result = card1Pair > card2Pair?"player1 win" : "player2 win";
                break;
            }
        }
        return result;
    }
    public int compareCardMapSize(Map<Integer, Integer> cardMap1, Map<Integer, Integer> cardMap2){
        if(cardMap1.size() > cardMap2.size()){
            return 1;
        }else if (cardMap1.size() < cardMap2.size()){
            return -1;
        }else {
            return 0;
        }
    }

    public Map<Integer, Integer> conversionCard(String cards){
        ArrayList<Integer> cardWeight = new ArrayList<>();
        String[] cardList = cards.split(" ");
        for(String card : cardList){
            switch (card.charAt(1)){
                case '2':
                    cardWeight.add(2);
                    break;
                case '3':
                    cardWeight.add(3);
                    break;
                case '4':
                    cardWeight.add(4);
                    break;
                case '5':
                    cardWeight.add(5);
                    break;
                case '6':
                    cardWeight.add(6);
                    break;
                case '7':
                    cardWeight.add(7);
                    break;
                case '8':
                    cardWeight.add(8);
                    break;
                case '9':
                    cardWeight.add(9);
                    break;
                case 'T':
                    cardWeight.add(10);
                    break;
                case 'J':
                    cardWeight.add(11);
                    break;
                case 'Q':
                    cardWeight.add(12);
                    break;
                case 'K':
                    cardWeight.add(13);
                    break;
                case 'A':
                    cardWeight.add(14);
                    break;
            }
        }
        Map<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return integer2 - integer1;
            }
        });
        for(int i=4; i>=0; i--){
            if(result.containsKey(cardWeight.get(i))){
                Integer weight = result.get(cardWeight.get(i));
                weight++;
                result.put(cardWeight.get(i),weight);
                continue;
            }
            result.put(cardWeight.get(i),1);
        }
        System.out.println(result);
        return result;
    }

}
