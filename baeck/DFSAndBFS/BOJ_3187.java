package baeck.DFSAndBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//양치기 꿍
public class BOJ_3187 {
    static int R, C; // R은 행의 수, C는 열의 수
    static char[][] map; // 농장의 상태를 저장하는 2차원 배열
    static boolean[][] visited; // 방문 여부를 저장하는 2차원 배열
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌 순서로 이동하기 위한 방향 벡터
    static int[] dc = {0, 1, 0, -1}; // 상, 우, 하, 좌 순서로 이동하기 위한 방향 벡터
    static int sheepTotal, wolfTotal; // 전체 양과 늑대의 수를 저장하는 변수

    static class Pair {
        int r, c; // 좌표를 저장하기 위한 Pair 클래스
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 방문하지 않은 모든 좌표에 대해 DFS 수행
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    Pair start = new Pair(i, j);
                    int[] result = dfs(start);
                    // 양의 수가 늑대의 수보다 많다면 양이 살아남고, 그렇지 않다면 늑대가 살아남음
                    if (result[0] > result[1]) {
                        sheepTotal += result[0];
                    } else {
                        wolfTotal += result[1];
                    }
                }
            }
        }

        System.out.println(sheepTotal + " " + wolfTotal); // 결과 출력
    }

    static int[] dfs(Pair start) {
        Stack<Pair> stack = new Stack<>(); // DFS를 위한 스택
        stack.push(start);
        visited[start.r][start.c] = true;

        int sheep = 0, wolf = 0;

        // 시작점이 양이나 늑대라면 카운트 증가
        if (map[start.r][start.c] == 'k') sheep++;
        else if (map[start.r][start.c] == 'v') wolf++;

        while (!stack.isEmpty()) {
            Pair cur = stack.pop();

            // 4방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 범위 내에 있고 방문하지 않은 점이며 울타리가 아닌지 확인
                if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                    if (map[nr][nc] != '#' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        stack.push(new Pair(nr, nc));

                        // 양이나 늑대라면 카운트 증가
                        if (map[nr][nc] == 'k') sheep++;
                        else if (map[nr][nc] == 'v') wolf++;
                    }
                }
            }
        }

        return new int[] {sheep, wolf}; // 해당 영역에 있는 양과 늑대의 수 반환
    }
}
