//package baeck;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
////차집합
//public class BOJ_1822 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int aNum = Integer.parseInt(st.nextToken());
//        int bNum = Integer.parseInt(st.nextToken());
//        int cnt = aNum;
//        //int[] ans = new int[aNum];
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        int[] A = new int[aNum];
//        int[] B = new int[bNum];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < aNum; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//            ans.add(A[i]);
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < bNum; i++) {
//            B[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(A);
//
//        for (int i = 0; i < B.length; i++) {
//            if (ans.contains(B[i])) {
//                cnt--;
//                //ans.remove(B[i]); Index 7 out of bounds for length 4 이런 오류 발생
//                ans.remove(Integer.valueOf(B[i]));
//            }
//        }
//        System.out.println(cnt);
//        for (int n :
//                ans) {
//            System.out.print(n + " ");
//        }
//
//    }
//}
//오류x, 제출 시 1차 시간초과 발생. GPT에게 물어보니 HashSet이라는게 차집합 구하는데 효율적이라고 함 ㄷㄷ;;


//package baeck;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.StringTokenizer;
//
//// 차집합
//public class BOJ_1822 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int aNum = Integer.parseInt(st.nextToken());
//        int bNum = Integer.parseInt(st.nextToken());
//
//        HashSet<Integer> setA = new HashSet<>();
//        HashSet<Integer> setB = new HashSet<>();
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < aNum; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            setA.add(num);
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < bNum; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            setB.add(num);
//        }
//
//        setA.removeAll(setB);
//
//        System.out.println(setA.size());
//        for (int num : setA) {
//            System.out.print(num + " ");
//        }
//    }
//}
//틀렸다고 함. 이유 : HashSet은 순서를 보장하지않는다. 예를들어 1,2,3 순서로 삽입해도, 읽는 순서는 1,3,2 일수도있고, 2,3,1 일수도 있다.
package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 차집합
public class BOJ_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());

        //List<Integer> setA = new ArrayList<>();
        //List<Integer> setB = new ArrayList<>();
        TreeSet<Integer> setA = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            setA.add(num);
        }

        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < bNum; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            setB.add(num);
//        }

        //Collections.sort(setA);
        //Collections.sort(setB);
        for (int i = 0; i < bNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            setA.remove(num);
        }
        //setA.removeAll(setB);

        System.out.println(setA.size());
        for (int num : setA) {
            System.out.print(num + " ");
        }
    }
}
