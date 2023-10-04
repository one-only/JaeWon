package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
public class BOJ_2961 {
    static int[][] tastes;
    static int minVal;
    static boolean[] visited;

    public static void makeSet(int current) {
        if (current == tastes.length) {
            int sour = 1;
            int bitter = 0;
            int cnt = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    cnt++;
                    sour *= tastes[i][0];
                    bitter += tastes[i][1];
                }
            }
            if(cnt == 0) return; //공집합이면 리턴
            if(minVal > Math.abs(sour - bitter))
                minVal = Math.abs(sour - bitter);
            return;
        }
        visited[current] = true;
        makeSet(current + 1);
        visited[current] = false;
        makeSet(current + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        minVal = Integer.MAX_VALUE;
        tastes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }
        makeSet(0);
        System.out.println(minVal);
    }

}
