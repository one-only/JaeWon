package baeck.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//N 번재 큰 수
public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                pq.add(input);

                if(pq.size() > N) {
                    pq.poll();
                }
            }
        }
        System.out.println(pq.peek());
    }
}


//    정렬 작업은 PriorityQueue(우선순위 큐)를 사용할 때 필요하지 않습니다. PriorityQueue는 요소를 추가할 때 자동으로 정렬하며, 가장 우선순위가 높은(최소값 또는 최대값, 우리 경우에는 최소값) 요소가 항상 맨 앞에 위치하게 됩니다.
//
//        따라서 PriorityQueue를 사용하면 요소를 추가할 때마다 자동으로 정렬이 되므로 추가적인 정렬 작업은 필요하지 않습니다. 코드 예시에서 보았듯이, PriorityQueue를 사용하여 N번째로 큰 수를 찾는데 정렬 작업을 따로 수행할 필요가 없습니다.
