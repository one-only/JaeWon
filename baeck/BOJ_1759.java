package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

//암호만들기
public class BOJ_1759 {
    static char[] input;
    static int[] check;
    static int L,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];
        check = new int[C];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);

        dfs(0, 0);

    }
    public static void dfs(int level, int length) {
        if(length == L) {
            StringBuilder sb = new StringBuilder();
            int vowel = 0;
            int consonant = 0;
            for (int i = 0; i < C; i++) {
                if(check[i] == 1) {
                    if (isVowel(input[i])) {
                        vowel++;
                    } else {
                        consonant++;
                    }
                    sb.append(input[i]);
                }
            }
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(sb);
            }
        } else {
            for (int i = level; i < C; i++) {
                check[i] = 1;
                dfs(i + 1, length + 1);
                check[i] = 0;
            }
        }
    }
    public static boolean isVowel(char c) {
        if (c == 'a' ||  c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

}
