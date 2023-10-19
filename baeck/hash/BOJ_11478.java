package baeck.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//부분문자열
public class BOJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = countSubstring(input);
        System.out.println(result);
    }
    static int countSubstring(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subString = s.substring(i, j);
                set.add(subString);
            }
        }
        return set.size();
    }
}
