package baeck.DFSAndBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS 인접행렬
public class BOJ_1260_1 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static boolean[][] visited; //방문여부 확인 배열을 이차원으로 사용하는 경우 다른 작업에 유용 하지만 메모리 사용량이 더 큼
    private static int N, M, V;

    private static void dfs(int v) {
        visited[V][v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
            if (map[v][i] == 1 && !visited[V][i]) {
                dfs(i);
            }
        }
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[V][start] = true;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 1; i <= N; i++) {
                if(map[v][i] == 1 && !visited[V][i]) {
                    queue.offer(i);
                    visited[V][i] = true;
                }
            }
        }
    }
    private static void resetVisited() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        //무방향 그래프일 경우
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(V);
        System.out.println();

        resetVisited();
        bfs(V);
    }
}
