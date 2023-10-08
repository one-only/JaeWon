package baeck;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


//로또
public class BOJ_6603 {
    static int N;
    static int[] input;
    static int[] nums;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            N = sc.nextInt();
            if(N == 0) break;

            input = new int[N];
            nums = new int[6];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.nextInt();
            }
            Arrays.sort(input);
            permutation(0, 0);
            System.out.println();

        }
        sc.close();

    }
    static void permutation(int start, int count) {
        if(count == 6) {
            for (int i = 0; i < 6; i++) {
                    System.out.print(nums[i] + " ");

            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            nums[count] = input[i];
            permutation(i + 1, count + 1);
        }
    }
}
