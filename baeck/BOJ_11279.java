package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//최대힙 힙의 경우 우선순위 큐 라는 자료구조를 사용하게 된다. 우선순위의 기본값은 최소
public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int tmp = Integer.parseInt(br.readLine());
            //priorityQueue.add(tmp);
            if (tmp>0) {
                priorityQueue.add(tmp);
            } else {
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }

    }
}
