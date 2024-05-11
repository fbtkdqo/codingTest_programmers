package lv1;

import java.util.*;

public class ex7 {
    //달리기 경주
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rank = new HashMap<>();

        for(int i = 0; i <players.length; i++) {
            rank.put(players[i], i);
        }

        for(String call: callings){
            System.out.println(">>>"+players[rank.get(call)]);

            String asisRank = players[rank.get(call)-1];
            String tobeRank = players[rank.get(call)];

            System.out.println("asis :"+asisRank);
            System.out.println("tobe :"+tobeRank);

            rank.replace(asisRank, rank.get(call));
            rank.replace(tobeRank, rank.get(call)-1);

            System.out.println(">>"+rank);
            players[rank.get(call)] = tobeRank;
            players[rank.get(call)+1] = asisRank;
            System.out.println("순위변동 :" + Arrays.toString(players));
        }

        System.out.println("최종순위 :"+ Arrays.toString(players));
        return players;
    }



    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players,callings)));
    }
}
