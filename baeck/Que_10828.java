package baeck;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Que_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TestCase = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();

        while(TestCase > 0) {
            String s = br.readLine();
            String spt[] = s.split(" ");
            TestCase--;
            switch(spt[0]) {
                case "push":
                    que.offer(Integer.parseInt(spt[1]));
                    break;
                case "pop":
                    if(que.isEmpty())
                        bw.write(-1+"\n");
                    else bw.write(que.poll() + "\n");
                    break;
                case "size":
                    bw.write(que.size() + "\n");
                    break;
                case "empty":
                    if(que.isEmpty())
                        bw.write(1+"\n");
                    else bw.write(0 + "\n");
                    break;
                case "front":
                    if(que.isEmpty())
                        bw.write(-1 + "\n");
                    else bw.write(que.peek() + "\n");
                    break;
                case "back":
                    if(que.isEmpty())
                        bw.write(-1 + "\n");
                    else bw.write(que.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
    }
}
