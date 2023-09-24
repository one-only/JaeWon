package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//arr[n] = arr[n-3] + arr[n-2] + arr[n-1];
//arr[0], arr[1], arr[2] 는 1, 2, 4 로 고정
public class add123_9095 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i <10; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        int TestCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TestCase; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n-1] + "\n");
        }
        System.out.print(sb);

    }
}
