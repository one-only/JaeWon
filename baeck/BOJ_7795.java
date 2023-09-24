package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//먹을 것인가 먹힐 것인가.
public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arrA = new int[N];
            int M = Integer.parseInt(st.nextToken());
            int[] arrB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int result = 0;
            int bIndex = 0;
            for (int x : arrA) {
                while (bIndex < M && arrB[bIndex] < x) {
                    bIndex++;
                }
                result += bIndex;
            }

            System.out.println(result);
        }
    }
}
