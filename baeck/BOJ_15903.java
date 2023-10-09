package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//카드 합체놀이
public class BOJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] input = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            Arrays.sort(input);
            long addMin = input[0]  + input[1];
            input[0] = addMin;
            input[1] = addMin;
        }
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += input[i];
        }
        System.out.println(sum);
    }
}
