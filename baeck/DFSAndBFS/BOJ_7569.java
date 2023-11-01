package baeck.DFSAndBFS;

//토마토
import java.util.*;

public class BOJ_7569 {
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 상자의 가로 길이
        int N = sc.nextInt(); // 상자의 세로 길이
        int H = sc.nextInt(); // 상자의 높이

        box = new int[H][N][M];
        Queue<Point> queue = new LinkedList<>(); // 익은 토마토의 좌표를 저장할 큐

        // 상자의 상태 입력받기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        queue.add(new Point(i, j, k)); // 익은 토마토의 좌표를 큐에 추가
                    }
                }
            }
        }

        int days = bfs(queue); // BFS를 통해 익는 날짜 계산

        if (checkAllTomatoesRipe()) { // 모든 토마토가 익었는지 확인
            System.out.println(days); // 익는 날짜 출력
        } else {
            System.out.println(-1); // 모든 토마토가 익지 못하는 경우 -1 출력
        }
    }

    static int bfs(Queue<Point> queue) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point p = queue.poll(); // 큐에서 익은 토마토의 좌표 꺼내기

                for (int j = 0; j < 6; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    int nz = p.z + dz[j];

                    // 상하좌우, 앞뒤 방향으로 익지 않은 토마토가 있다면 익게 만들고 큐에 추가
                    if (nx >= 0 && nx < box.length && ny >= 0 && ny < box[0].length && nz >= 0 && nz < box[0][0].length) {
                        if (box[nx][ny][nz] == 0) {
                            box[nx][ny][nz] = 1;
                            queue.add(new Point(nx, ny, nz));
                        }
                    }
                }
            }

            if (!queue.isEmpty()) {
                days++; // 날짜 증가
            }
        }

        return days;
    }

    static boolean checkAllTomatoesRipe() {
        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                for (int k = 0; k < box[0][0].length; k++) {
                    if (box[i][j][k] == 0) {
                        return false; // 익지 않은 토마토가 있으면 false 반환
                    }
                }
            }
        }
        return true; // 모든 토마토가 익었으면 true 반환
    }

    static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
