package baeck;

import java.util.Scanner;

//부분수열의 합
public class BOJ_1182 {
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);
        if(S == 0) {
            count--; //공집합
            System.out.println(count);
        } else System.out.println(count);
    }
    private static void dfs (int start, int currentSum) {
        if(start == N) {
            if (currentSum == S) {
                count++;
            }
            return;
        }
        dfs(start + 1, currentSum + arr[start]);
        dfs(start + 1, currentSum);
    }
}
