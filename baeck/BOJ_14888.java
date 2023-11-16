package baeck;

import java.util.Scanner;
//연산자 끼워넣기
public class BOJ_14888 {
    static int N;
    static int[] number;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        number = new int[N];

        for(int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(number[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int idx) {
        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0: dfs(num + number[idx], idx + 1); break;
                    case 1: dfs(num - number[idx], idx + 1); break;
                    case 2: dfs(num * number[idx], idx + 1); break;
                    case 3: dfs(num / number[idx], idx + 1); break;
                }

                operator[i]++;
            }
        }
    }
}
