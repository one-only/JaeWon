package baeck.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//단지번호 붙이기
class BOJ_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> danjiSizes = new ArrayList<>();

        // 모든 위치에 대해서 BFS를 수행하여 단지 크기를 찾는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int danjiSize = bfs(i, j);
                    danjiSizes.add(danjiSize);
                }
            }
        }

        // 결과 출력
        Collections.sort(danjiSizes);
        System.out.println(danjiSizes.size());
        for (int size : danjiSizes) {
            System.out.println(size);
        }
    }

    // BFS로 단지 크기를 구하는 함수
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int danjiSize = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N
                        && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    danjiSize++;
                }
            }
        }

        return danjiSize;
    }
}

