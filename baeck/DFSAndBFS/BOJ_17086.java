package baeck.DFSAndBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어2
public class BOJ_17086 {
    private static int[][] map;
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, bfs(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 상어를 만난 경우, 현재까지의 거리 반환
            if (map[x][y] == 1) {
                return distance;
            }

            // 상하좌우와 대각선 방향으로 이동
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 위치이고 아직 방문하지 않은 경우
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return 0;
    }

    // 주어진 위치가 유효한지 확인하는 함수
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

