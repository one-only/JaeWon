package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나이트의 이동
public class BOJ_7562 {
    //나이트가 이동할 수 있는 8가지 방향 x,y 저장
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {
            int N = Integer.parseInt(br.readLine()); //체스판의 크기
            int[][] chessBoard = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int ans = bfs(N, startX, startY, endX, endY, chessBoard);
            System.out.println(ans);
        }
    }

    static int bfs(int N, int startX, int startY, int endX, int endY, int[][] chessBoard) {
        Queue<int[]> queue = new LinkedList<>();//BFS를 위한 큐 생성
        queue.offer(new int[]{startX, startY});// 시작 위치를 큐에 삽입
        chessBoard[startX][startY] = 0; //시작 위치의 이동 횟수를 0으로 초기화

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(x == endX && y == endY) {
                return chessBoard[x][y];
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && chessBoard[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    chessBoard[nx][ny] = chessBoard[x][y] + 1; //이동 횟수를 1 증가
                }
            }
        }
        return -1; //목표 위치(endx, endy)에 도달할 수 없는 경우 -1 반환
    }
}
