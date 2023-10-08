package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역 구하기
public class BOJ_2468 {
    static int[][] map; //입력값 저장 배열
    static boolean[][] visited;//방문여부 저장 배열
    static int N;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
//    위로 이동: (dx[0], dy[0]) -> (0, 1)
//    오른쪽으로 이동: (dx[1], dy[1]) -> (1, 0)
//    아래로 이동: (dx[2], dy[2]) -> (0, -1)
//    왼쪽으로 이동: (dx[3], dy[3]) -> (-1, 0)

    static class Node {//좌표를 저장하기 위한 클래스
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i <= 100; i++) {// 0~ 100까지 순회하며 안전한 영역의 최대 개수를 찾는다. 0부터인 이유는 아무 지역도 물에 잠기지 않는 경우를 고려
            visited = new boolean[N][N];
            max = Math.max(max, bfs(i));
        }
        System.out.println(max);
    }


    public static int bfs(int n) {
        int ret = 0; // 안전영역의 개수를 저장하는 변수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] <= n || visited[i][j]) continue; // 현재 지점의 높이가 n 보다 작거나(물에 잠긴 곳)
                                                              // 이미 방문한 지점인 경우에는 무시하고 넘어감
                Queue<Node> q = new LinkedList<>();
                visited[i][j] = true;
                q.add(new Node(i, j));

                while (!q.isEmpty()) {
                    Node cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) { // 현재 위치에서 상하좌우로 이동하면서 주변 지점을 검사, dir은 상하좌우 방향을 나타냄
                        int ny = cur.y + dy[dir];
                        int nx = cur.x + dx[dir];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue; //주변 지점이 지도 범위를 벗어나는 경우 무시
                        if(map[ny][nx] <= n || visited[ny][nx]) continue; // 현재 지점의 높이가 n 보다 작거나 이미 방문한 지점인 경우에는 무시하고 넘어감

                        visited[ny][nx] = true;
                        q.add(new Node(ny, nx));
                    }
                }
                ret++;
            }
        }
        return ret;
    }
}