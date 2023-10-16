package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//게임을 만든 동준이
public class BOJ_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int level = Integer.parseInt(br.readLine());

        int scores[] = new int[level];
        for (int i = 0; i < level; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int sub = 0;
        int total = 0;
        //int maxScore = scores[level - 1];
        for (int i = level - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (scores[j] >= scores[i]) {
                    sub = Math.abs(scores[j] - scores[i]) + 1;
                    scores[j] = scores[i] - 1;
                    total += sub;
                    //break;
                }
            }
        }
        System.out.println(total);
    }
}
