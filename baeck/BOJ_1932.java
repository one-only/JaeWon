package baeck;

import java.util.Scanner;

//정수 삼각형
public class BOJ_1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        // 삼각형의 각 숫자를 입력 받습니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        // dp의 첫 번째 값은 삼각형의 첫 번째 값으로 초기화합니다.
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 가장 왼쪽에 위치한 경우
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                // 가장 오른쪽에 위치한 경우
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                // 그 외의 경우
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // dp의 마지막 행에서 가장 큰 값 찾기
        int max = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);

        scanner.close();
    }
}
