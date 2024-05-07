package lv1;

import java.util.HashMap;
import java.util.Map;

public class ex1 {

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Map<String,Integer>> giftRecords = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();

        for (String friend : friends) {
            giftRecords.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] from = gift.split(" ");
            String giver = from[0];
            String receiver = from[1];

            giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver, 0) + 1);
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }

        System.out.println(giftScore);







        return giftScore.get(giftRecords.keySet().iterator().next());
    }


    public static void main(String[] args) {
        String[] friends = new String[] {"a", "b", "c", "d", "e", "f"};

        String[] gifts = new String[] {"a b", "b a", "b a", "a d", "b a", "a b"};

        System.out.println(solution(friends, gifts));
    }
}
