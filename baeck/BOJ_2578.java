package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//빙고
public class BOJ_2578 {
    static int[][] myArr;
    static int count;//빙고 개수
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        myArr = new int[5][5];
        count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                myArr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= 25; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(myArr[j][k] == num) myArr[j][k] = 0;
                }
            }
            rCheck();
            cCheck();
            leftToRightCrossCheck();
            rightToLeftCrossCheck();
            if(count >= 3) {
                System.out.println(i);
                break;
            }
            count=0;
        }

    }
    public static void rCheck() {
        for (int i = 0; i < 5; i++) {
            int countZero = 0;
            for (int j = 0; j < 5; j++) {
                if(myArr[i][j] == 0) {
                    countZero++;
                }
                if(countZero == 5) count++;
            }
        }
    }
    public static void cCheck() {
        for (int i = 0; i < 5; i++) {
            int countZero = 0;
            for (int j = 0; j < 5; j++) {
                if(myArr[j][i] == 0) {
                    countZero++;
                }
                if(countZero == 5) count++;
            }
        }
    }
    public static void leftToRightCrossCheck() {
        int countZero = 0;
        for (int i = 0; i < 5; i++) {
            if(myArr[i][i] == 0) countZero++;
        }
        if(countZero == 5) count++;
    }
    public static void rightToLeftCrossCheck() {
        int countZero = 0;
        for (int i = 0; i < 5; i++) {
            if(myArr[i][4-i] == 0) countZero++;
        }
        if(countZero == 5) count++;
    }
}
