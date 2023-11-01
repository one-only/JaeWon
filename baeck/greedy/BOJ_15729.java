package baeck.greedy;


import java.io.IOException;
import java.util.Scanner;

//방탈출
public class BOJ_15729 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = sc.nextInt();
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            if(arr[i] != target[i]) {
                count++;
                for (int j = i; j < N && j <= i + 2; j++) {
                    arr[j] ^= 1;
                }
            }
        }
        System.out.println(count);

    }
}
