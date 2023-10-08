package baeck;

import java.util.Scanner;

// 떡먹는 호랑이 (피보나치 수열)
public class BOJ_2502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        int[] fibo = new int[D + 1];
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i <= D; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        int a = 1;
        int b;
        while (true) {
            if((K-fibo[D-3]*a)%fibo[D-2]==0) {
                b = (K-fibo[D-3]*a)/fibo[D-2];
                break;
            }
            a++;
        }
        System.out.println(a);
        System.out.println(b);

    }
}
