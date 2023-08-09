package baeck.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class top_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int[] top = new int[testCase];
        for(int i = 0 ; i < testCase ; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }
        int[] DP = new int[testCase];
        DP[0] = 0;
        for (int i = 1; i < testCase; i++) {
            if(top[i] >= top[i-1]) {
                int start = DP[i-1];
                for (int j = start; j >= 0; j--) {
                    if(top[j] > top[i]) {
                        DP[i] = j + 1;
                        break;
                    }
                }
            } else {
                DP[i] = i;
            }
        }
        for(int dp : DP) {
            sb.append(dp).append(" ");
        }
        System.out.println(sb);
    }
}
