package lv1;

import java.util.HashMap;

public class ex1 {
    
    //프로그래머스 - 가장 많이 받은 선물

    public static int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String,Integer>> giftRecords = new HashMap<>();
        HashMap<String, Integer> giftScore = new HashMap<>();

        //1. 초기값 생성
        for (String friend : friends) {
            giftRecords.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
        }


        //2. 선물 횟수 / 선물 지수 데이터 생성
        for (String gift : gifts) {
            String[] from = gift.split(" ");
            String giver = from[0];
            String receiver = from[1];

            giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver, 0) + 1);
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);

            System.out.println(giftScore);
        }


        //3. 결과
        int answer = 0;
        String answerName = "";
        for(String giver:friends){
            int gift = 0;
            for(String receiver: friends) {
                if(!giver.equals(receiver)){
                    int send = giftRecords.get(giver).getOrDefault(receiver, 0);
                    int recv = giftRecords.get(receiver).getOrDefault(giver, 0);

                    if(send>recv) {
                        //준 횟수가 많으면 +1
                        gift++;
                    } else if (recv == send && giftScore.get(giver)>giftScore.get(receiver)) {
                        gift++;
                    }
                }

                System.out.println(gift);
            }

            if(answer < gift) {
                answer = gift;
                answerName = giver;
            }
        }

        System.out.println(answerName);

        return answer;
    }

    public static void main(String[] args) {
        String[] friends = new String[] {"muzi", "ryan", "frodo", "neo"};

        String[] gifts = new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution(friends, gifts));
    }
}
