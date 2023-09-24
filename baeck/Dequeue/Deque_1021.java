package baeck.Dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deque_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] tmp = new int[M];
        for (int i = 0; i < M; i++) {
            tmp[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        for (int i = 0; i < M; i++) {
            int halfIndex;
            if(deque.size()%2 == 0) {
                halfIndex = deque.size() / 2 -1;
            } else {
                halfIndex = deque.size() / 2;
            }
            if(deque.indexOf(tmp[i]) <= halfIndex) {
                while(tmp[i] != deque.get(0)) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
            } else {
                while (tmp[i] != deque.get(0)) {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.poll();
        }
        System.out.println(answer);

    }
}
