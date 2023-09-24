package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//요세푸스문제
public class BOJ_S5_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Queue<Integer> que = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder str = new StringBuilder();
        str.append("<");
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }
        while(!que.isEmpty()) {
            if(que.size() == 1) {
                str.append(que.poll());
            } else {
                for(int i = 0; i < K -1 ; i++) {
                    que.offer(que.poll());
                }
                str.append(que.poll()).append(", ");
            }
        }
        str.append(">");
        System.out.println(str);
    }
}
