package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//로봇청소기
public class BOJ_14503 {

    static int y, x, count;
    static int map[][];
    static boolean visit[][];
    static int dy[] = {-1, 0, 1, 0}; //y는 행의 변화, 북 동 남 서
    static int dx[] = {0, 1, 0, -1};// x는 열의 변화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        visit = new boolean[y][x];

        //시작위치, 방향 저장
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 방향: 0-> 북, 1->동, 2->남, 3-> 서 0, 3, 2, 1 순으로 회전함
        count = 0;

        //map 저장 이중 for문
        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }


    public static void dfs(int r, int c, int d) {
        boolean sign = false;
        //시작위치가 0이면 청소 후 count++
        if(!visit[r][c]) {
            visit[r][c] = true;
            count++;
        }
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; //반시계 방향으로 90도 회전이기 때문에. 만약 시계방향으로 90도 회전인 경우 (d + 1) % 4를 해야함
            //d 방향으로 이동했다고 가정
            int ay = r + dy[d];
            int ax = c + dx[d];
            if (ay >= 0 && ay < y && ax >=0 && ax < x) {
                if(map[ay][ax] == 0 && !visit[ay][ax]) { //이동했을 때 위치가 0이고, 방문배열이 false 이면
                    dfs(ay, ax, d); // 이동 위치에서 다시 재귀호출
                    sign = true; //재귀호출을 계속 했는데 결국 4방향 모두 청소할 곳이 없음!
                    break;
                }
            }

        }
        if(sign == false) {
            int back = (d + 2) % 4;// 바라보는 방향의 뒤로 움직이는거기 때문에 2만 더해준다.
            int by = r + dy[back];
            int bx = c + dx[back];

            if(by>=0 && by<y && bx>=0 && bx<x && map[by][bx] != 1) {
                dfs(by, bx, d);
            }
        }

    }
}
//방법1 : 방문시 0->2로 수정
//방법2 : 방문 배열 visit[][] 배열을 만들어서 처음에는 디폴트값이 false, 방문하면 true로 변경