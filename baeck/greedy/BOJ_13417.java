package baeck.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//카드 문자열
public class BOJ_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            Deque<Character> deque = new ArrayDeque<>();
            deque.add(input[0].charAt(0));
            for (int j = 1; j < N; j++) {
                if(deque.peekFirst() >= input[j].charAt(0)) {
                    deque.addFirst(input[j].charAt(0));
                } else {
                    deque.addLast(input[j].charAt(0));
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            System.out.println(sb.toString());

        }

    }
}
