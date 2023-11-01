package baeck.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호
public class BOJ_9012 {
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            boolean check = checkStack(input);
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
    static boolean checkStack(String input) {
        stack = new Stack<>();
        for (char a : input.toCharArray()) {
            if(a == '(') {
                stack.push(a);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
