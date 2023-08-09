package baeck.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        //입력값들 저장 할 배열
        int[] arr = new int[N];
        //입력값 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0 ; i < N ; i++) {
            int num = arr[i];
            if(num >= index) {
                while(num >= index) {
                    stack.push(index++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int x = stack.pop();
                if(x > num) {
                    break;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}