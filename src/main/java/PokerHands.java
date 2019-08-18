import java.util.*;

public class PokerHands {

    public String compareTwoCards(String player1Card, String player2Card) {
        Map<Integer, Integer> cards1 = conversionCard(player1Card);
        Map<Integer, Integer> cards2 = conversionCard(player2Card);
        String result = "draw";
        if(compareCardMapSize(cards1,cards2) == 0){
            if(cards1.size() == 5){
                if(getStraightMaxValue(cards1) == 0 && getStraightMaxValue(cards2) == 0){
                    result = compareTwoCardWithHighestValue(cards1,cards2);
                }else {
                    result = getStraightMaxValue(cards1) > getStraightMaxValue(cards2)?"player1 win" : "player2 win";
                }
            }else if(cards1.size() == 4){
                result = compareTwoCardWithPair(cards1,cards2);
            }else if(cards1.size() == 3){
                result = compareTwoCardWhenMapSizeIsThree(cards1,cards2);
            }
        }else {
            if(getStraightMaxValue(cards1) == 0 && getStraightMaxValue(cards2) == 0){
                result = compareCardMapSize(cards1,cards2) == -1?"player1 win" : "player2 win";
            }else {
                result = getStraightMaxValue(cards1) > getStraightMaxValue(cards2)?"player1 win" : "player2 win";
            }

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
            if(card1.getValue() == 2) card1Pair = card1.getKey();

            Map.Entry<Integer, Integer> card2 = card2Iterator.next();
            if(2 == card2.getValue()) card2Pair = card2.getKey();

            if(card1Pair != null && card2Pair!= null){
                if(card1Pair.equals(card2Pair)){
                    result = compareTwoCardWithHighestValue(cards1,cards2);
                    break;
                }
                result = card1Pair > card2Pair?"player1 win" : "player2 win";
                break;
            }
        }
        return result;
    }
    public String compareTwoCardWhenMapSizeIsThree(Map<Integer, Integer> cards1, Map<Integer, Integer> cards2){
        String result = null;
        Map.Entry<Integer, Integer> card1MaxValue = getMapMaxValueEntry(cards1);
        Map.Entry<Integer, Integer> card2MaxValue = getMapMaxValueEntry(cards2);
        if(card1MaxValue.getValue() == card2MaxValue.getValue()){
            if(card1MaxValue.getValue() == 2){
                result = compareCardsWithTwoPair(cards1,cards2);
            }else if(card1MaxValue.getValue() == 3){
                result = card1MaxValue.getKey() > card2MaxValue.getKey() ? "player1 win" : "player2 win";
            }
        }else{
            result = (card1MaxValue.getValue() > card2MaxValue.getValue()) ? "player1 win" : "player2 win";
        }
        return result;
    }

    public String compareCardsWithTwoPair(Map<Integer, Integer> cards1, Map<Integer, Integer> cards2){
        String result = null;
        Iterator<Map.Entry<Integer, Integer>> card1Iterator = cards1.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> card2Iterator = cards2.entrySet().iterator();
        Map<Integer, Integer> card1Pairs = new TreeMap<>((integer1, integer2) -> integer2 - integer1);
        Map<Integer, Integer> card2Pairs = new TreeMap<>((integer1, integer2) -> integer2 - integer1);
        while (card1Iterator.hasNext() && card2Iterator.hasNext()){
            Map.Entry<Integer, Integer> card1 = card1Iterator.next();
            if(card1.getValue() == 2) card1Pairs.put(card1.getKey(),card1.getValue());
            Map.Entry<Integer, Integer> card2 = card2Iterator.next();
            if(2 == card2.getValue()) card2Pairs.put(card2.getKey(),card2.getValue());
        }
        if(card1Pairs != null && card2Pairs != null){
            result = compareTwoCardWithHighestValue(card1Pairs, card2Pairs);
            if("draw".equals(result)){
                result = compareTwoCardWithHighestValue(cards1,cards2);
            }
        }
        return result;
    }
    public Map.Entry<Integer,Integer> getMapMaxValueEntry(Map<Integer,Integer> map){
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        Map.Entry<Integer,Integer> maxValueEntry = iterator.next();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            maxValueEntry = maxValueEntry.getValue() > next.getValue() ?maxValueEntry:next;
        }
        return maxValueEntry;
    }

    public int getStraightMaxValue(Map<Integer, Integer> card){
        Iterator<Map.Entry<Integer, Integer>> iterator = card.entrySet().iterator();
        Map.Entry<Integer, Integer> lastCard = iterator.next();
        int result = lastCard.getKey();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> currentCard = iterator.next();
            if((lastCard.getKey() - currentCard.getKey()) == 1){
                lastCard = currentCard;
            }else {
                System.out.println("00000000");
                return 0;
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
        Map<Integer, Integer> result = new TreeMap<>((integer1, integer2) -> integer2 - integer1);
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
