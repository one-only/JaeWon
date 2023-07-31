package baeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class area_2583 {
    static int Y; // 높이
    static int X; // 너비
    static int K; //직사각형 개수

    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1}; //상하좌우

    static int[][] map; // 지도

    static int count = 0; // 영역 구하기

    static ArrayList<Integer> List;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Y = sc.nextInt(); //map 높이
        X = sc.nextInt(); //map 너비
        K = sc.nextInt(); //직사각형 개수

        map = new int[Y][X]; //map

        //직사각형 구해서 영역들 1로 넣기
        for(int i=0;i<K;i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int a=y1;a<y2;a++) {
                for(int b=x1;b<x2;b++) {
                    map[a][b] = 1;
                }
            }
        }

        List = new ArrayList<Integer>(); // 그 영역 넓이 저장

        for(int i = 0; i< Y; i++) {
            for(int j = 0; j< X; j++) {
                if(map[i][j]==0) {
                    count = 0;
                    DFS(i,j);
                    List.add(count);
                }
            }
        }

        //List에 들어간 넓이의 개수를 구하면 그게 직사각형의 개수
        System.out.println(List.size());

        Collections.sort(List);

        for(Integer c : List) System.out.print(c + " ");
    }

    public static void DFS(int r, int c) {
        map[r][c] = 1;
        count++;

        for(int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nc >=0 && nr< Y && nc< X) {
                if(map[nr][nc]==0) DFS(nr,nc);
            }
        }
    }
}
