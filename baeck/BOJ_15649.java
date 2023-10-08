package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M
public class BOJ_15649 {
    static int[] input;
    static boolean[] visited;
    static int[] result;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        visited = new boolean[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }
        permutation(input, result, visited, 0, M);
    }
    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if(depth == r) {
            for (int num :
                    out) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
}
