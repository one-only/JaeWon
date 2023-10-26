package baeck.DFSAndBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DFS와 BFS (인접리스트)
public class BOJ_1260_2 {
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;

    public static void dfs(int x) {
        if(visited[x]) {
            return;
        }
        visited[x] = true;
        System.out.print(x + " ");
        for (int y :list[x]){
            if (!visited[y]) dfs(y);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : list[x]){
                if (!visited[y]) {
                    visited[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()); //V
        list = (ArrayList<Integer>[]) new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        visited = new boolean[N + 1];
        dfs(start);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(start);
    }
}
//1260_1과 비교했을 때 메모리도 줄어들고, 시간도 줄어들었다.