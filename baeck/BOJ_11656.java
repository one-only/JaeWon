package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//접미사 배열
public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int len = input.length();
        String[] tmps = new String[len];

        for (int i = 0; i < len; i++) {
            tmps[i] = input.substring(i);
        }

        Arrays.sort(tmps);

        for (String tmp:
             tmps) {
            System.out.println(tmp);
        }
    }
}
