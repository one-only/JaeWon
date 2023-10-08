package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백설 공주와 일곱 난쟁이
public class BOJ_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (arr[k] != arr[i] && arr[k] != arr[j]) {
                            System.out.println(arr[k]);
                        }
                    }
                    return ;
                }
            }
        }
    }
}
