package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//에라토스테네스의 체
public class BOJ_2960 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if(arr[j] > 0) {
                    arr[j] = 0;
                    cnt++;
                    if(cnt == K) {
                        System.out.println(j);
                    }
                } else if(arr[j] == 0) {
                    continue;
                }
            }
        }

    }
}
