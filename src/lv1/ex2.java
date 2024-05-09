package lv1;

public class ex2 {

    //프로그래머스 [PCCP 기출문제] 붕대 감기

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int t = bandage[0]; //시전시간
        int x = bandage[1]; //초당 회복량
        int y = bandage[2]; //추가 회복량

        int bandageTime = 0; //연속 붕대감기 시간

        int user = health;

        for(int i = 0; i < attacks[attacks.length-1][0]; i++) {

            ++bandageTime;
            int attackTime = attacks[i][0];
            int attackDamage = attacks[i][1];

            bandageTime = attackTime;

            System.out.println("atTime :"+attackTime);
            System.out.println("banTime :"+bandageTime);
            System.out.println("atDmg :"+attackDamage);
            System.out.println("beforeUser :"+user);


            if( user < health ) {
                user += (bandageTime*x);
                System.out.println("heal!! : " + (bandageTime*x));

                if(bandageTime/t > 0){
                    user += (y*(bandageTime/t));

                    System.out.println("plusHeal : "+(y*(bandageTime/t)));
                }

                if(user > 30) {
                    user = 30;
                }
            }

            user -= attackDamage;

            bandageTime = 0;

            System.out.println("afterUser :"+user);

            if(health < 0) {
                return -1;
            }
            answer = user;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        System.out.println(solution(bandage, health, attacks));
    }
}
