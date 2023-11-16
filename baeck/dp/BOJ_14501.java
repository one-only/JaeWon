package baeck.dp;

import java.util.Scanner;

//퇴사
public class BOJ_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+5];
        int[] P = new int[N+5];
        int[] dp = new int[N+5];
        for(int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for(int i = N; i > 0; i--) {
            int day = i + T[i]; // 상담이 끝나는 날
            if(day <= N+1) // 상담이 끝나는 날이 퇴사일을 넘지 않으면
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]); // 오늘 상담을 하는 경우 vs 오늘 상담을 하지 않는 경우
            else
                dp[i] = dp[i+1]; // 상담이 끝나는 날이 퇴사일을 넘으면 오늘 상담을 하지 않는다.
        }
        System.out.println(dp[1]);
    }
}
