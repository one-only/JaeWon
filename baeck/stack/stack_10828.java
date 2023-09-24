package baeck.stack;

import java.io.*;
import java.util.Stack;

public class stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (testCase > 0) {
            String s = br.readLine();
            String split[] = s.split(" ");
            testCase--;
            switch(split[0]) {
                case "push":
                    stack.push(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        bw.write(-1+"\n");
                    else bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        bw.write(1+"\n");
                    else bw.write(0 + "\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        bw.write(-1 + "\n");
                    else bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
    }
}
