package baeck;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class card2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }
        while(que.size() != 1) {
            que.poll();
            que.offer(que.poll());
        }
        System.out.println(que.peek());
        //bw.write(que.peek());
        //bw.flush();
    }
}
