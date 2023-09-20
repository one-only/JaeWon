package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

// 숫자 카드
public class BOJ_10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> aNums = new HashSet<>();
        int aNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            aNums.add(num);
        }
        int bNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(aNums.contains(num)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int aNum = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        ArrayList<Integer> aNums = new ArrayList<>();
//
//        for (int i = 0; i < aNum; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            aNums.add(num);
//        }
//        int bNum = Integer.parseInt(br.readLine());
//        int[] ans = new int[bNum];
//        st = new StringTokenizer(br.readLine());
//        ArrayList<Integer> bNums = new ArrayList<>();
//        for (int i = 0; i < bNum; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            bNums.add(num);
//            if(bNums.contains(aNums)) {
//                ans[i] = 1;
//            } else {
//                ans[i] = 0;
//            }
//        }
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
//    }
//public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int aNum = Integer.parseInt(br.readLine());
//        int[] aNums = new int[aNum];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < aNum; i++) {
//            aNums[i] = Integer.parseInt(st.nextToken());
//        }
//        int bNum = Integer.parseInt(br.readLine());
//        int[] bNums = new int[bNum];
//        int[] ans = new int[bNum];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < bNum; i++) {
//            bNums[i] = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < aNum; j++) {
//                if (bNums[i] == aNums[j]) {
//                    ans[i] = 1;
//                    break;
//                } else {
//                    ans[i] = 0;
//                }
//            }
//        }
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
//    } // 시간초과.... 제 생각에는 이중 for문 때문에 시간초과가 걸리는 것 같다.. HashSet으로 풀어보자