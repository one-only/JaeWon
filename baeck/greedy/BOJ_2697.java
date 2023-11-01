package baeck.greedy;

import java.util.Scanner;
//다음 수 구하기
public class BOJ_2697 {
    // 주어진 배열 a에서 다음 순열을 찾는 함수
    static boolean next_permutation(int[] a) {
        // 1. a[i-1] < a[i]를 만족하는 가장 큰 i를 찾는다.
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        // 이미 주어진 배열 a가 내림차순이면, 즉 마지막 순열이면 false를 반환한다.
        if (i <= 0) {
            return false;
        }

        // 2. j >= i이면서 a[j] > a[i-1]를 만족하는 가장 큰 j를 찾는다.
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        // 3. a[i-1]과 a[j]를 swap한다.
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // 4. a[i]부터 끝까지를 뒤집는다.
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int[] a = new int[s.length()];
            for (int i=0; i<s.length(); i++) {
                a[i] = s.charAt(i) - '0';
            }
            if (next_permutation(a)) {
                for (int i=0; i<a.length; i++) {
                    System.out.print(a[i]);
                }
                System.out.println();
            } else {
                System.out.println("BIGGEST");
            }
        }
    }
}
