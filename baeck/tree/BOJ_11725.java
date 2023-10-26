package baeck.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트리의 부모 찾기
public class BOJ_11725 {
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        arrayList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 1; i++) { //N개의 노드, N-1개의 간선으로 구성되어있어서 범위가 < N-1임
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            //양방향 간선이기 때문에
            arrayList.get(num1).add(num2);
            arrayList.get(num2).add(num1);
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N ; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < arrayList.get(cur).size(); i++) {
                if (!visited[arrayList.get(cur).get(i)]) {
                    queue.add(arrayList.get(cur).get(i));
                    parent[arrayList.get(cur).get(i)] = cur;
                    visited[arrayList.get(cur).get(i)] = true;
                }
            }
        }
    }
}
