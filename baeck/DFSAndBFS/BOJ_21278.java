package baeck.DFSAndBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//호석이 두마리 치킨
public class BOJ_21278 {
    static int N, M; // 건물의 개수(N)와 도로의 개수(M)
    static List<Integer>[] graph; // 건물 간의 연결 정보를 저장할 그래프
    static int[] chicken = new int[2]; // 치킨집 위치를 저장할 배열
    static int sum, min = Integer.MAX_VALUE; // 치킨집 거리의 합(sum)과 최소 거리(min)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 정보 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 모든 치킨집 조합에 대해 거리 합 계산하기
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                sum = 0;
                for (int k = 1; k <= N; k++) {
                    if (k == i || k == j) continue;
                    int dist = bfs(k, i) + bfs(k, j);
                    sum += dist;
                }
                // 최소 거리 업데이트
                if (sum < min) {
                    min = sum;
                    chicken[0] = i;
                    chicken[1] = j;
                }
            }
        }

        // 결과 출력
        System.out.println(chicken[0] + " " + chicken[1] + " " + min);
    }

    // BFS를 사용하여 시작점부터 도착점까지의 최단 거리를 계산하는 메소드
    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return distance[cur];
            }
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
