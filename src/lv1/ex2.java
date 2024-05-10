package lv1;

public class ex2 {

    //프로그래머스 [PCCP 기출문제] 붕대 감기

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; //시전시간
        int x = bandage[1]; //초당 회복량
        int y = bandage[2]; //추가 회복량

        int bandageTime = 0; //연속 붕대감기 시간

        int user = health;

        System.out.println("마지막 공격시간:"+attacks[attacks.length-1][0]);

        for(int i = 1; i <= attacks[attacks.length-1][0]; i++) {


            ++bandageTime;
            System.out.print("시간 :"+ i);
            System.out.print(" banTime :"+bandageTime);
            System.out.print(" beforeUser :"+user);

            for (int[] attack : attacks) {
                int attackYN = attack[0];
                int attackDamage = attack[1];

                if (attackYN == i) {
                    bandageTime = 0;
                    System.out.print(" attackTime :"+i);
                    System.out.print(" attack! :" + attackDamage);
                    user -= attackDamage;
                }
            }


            if( user < health && bandageTime > 0 ) {
                user += x;
                System.out.print(" heal!! : " +x);

                if(bandageTime%t == 0 && bandageTime/t > 0){
                    user += y;

                    System.out.print(" plusHeal : "+y);
                }

                if(user > health) {
                    user = health;
                }
            }

            System.out.println(" afterUser :"+user);

            if(user <= 0) {
                System.out.println("user 사망");
                return -1;
            }
        }


        return user;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 45;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}, {13, 19}};

        System.out.println(solution(bandage, health, attacks));
    }
}
