package lv1;

import java.util.ArrayList;

public class ex10 {
    //자연수 뒤집어 배열로 만들기
    public static ArrayList<Long> solution(long n) {
        ArrayList<Long> answer = new ArrayList<>();


        while(n > 0) {
            answer.add(n%10);
            n /= 10;
        }


        return answer;
    }
    public static void main(String[] args) {
        long n = 12345;

        System.out.println(solution(n));
    }
}
