package baeck.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간관리
public class BOJ_1263 {
    static class Task implements Comparable<Task> {
        int time, endTime;
        public Task(int st, int et) {
            this.time = st;
            this.endTime = et;
        }
        @Override
        public int compareTo(Task o) {
            return o.endTime - this.endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            pq.offer(new Task(T, S));
        }
        int now = 1000001;

//        만약 (현재시간 > 현재 일의 마감시간) 이라면:
//        현재시간 = 현재 마감시간 - 현재 걸리는시간
//        아니라면:
//        현재시간 = 현재시간 - 현재 걸리는시간
        while(!pq.isEmpty()) {
            Task task=pq.poll();
            if(now > task.time) {
                now = Math.min(now - task.time, task.endTime - task.time);
            } else {
                now = now - task.time;
            }
        }
        if(now < 1) now = -1;
        System.out.println(now);
    }
}
