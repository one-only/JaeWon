package baeck.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                stack.push(num);

            } else {
                stack.pop();
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
