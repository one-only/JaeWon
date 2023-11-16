package baeck.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기 2
public class BOJ_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; // 최소 연산 횟수를 저장할 배열
        int[] prev = new int[N + 1]; // 이전 수를 저장할 배열

        dp[1] = 0; // 1은 이미 1이므로 연산 횟수는 0입니다.

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 연산 1: 현재 수에서 1을 뺀 경우
            prev[i] = i - 1; // 이전 수는 현재 수에서 1을 뺀 수입니다.

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                // 연산 2: 현재 수가 2로 나누어 떨어지는 경우
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                // 연산 3: 현재 수가 3으로 나누어 떨어지는 경우
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[N]); // N을 1로 만드는 최소 연산 횟수 출력

        // 경로 역추적
        StringBuilder sb = new StringBuilder();
        int num = N;
        while (num != 1) {
            sb.append(num).append(" ");
            num = prev[num];
        }
        sb.append(1);
        System.out.println(sb.reverse()); // 경로 출력
    }
}
