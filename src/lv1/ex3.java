package lv1;

import java.util.Scanner;

public class ex3 {

    //[PCCE] 피타고라스의 정리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = c*c - a*a;

        System.out.println(b_square);
    }
}
