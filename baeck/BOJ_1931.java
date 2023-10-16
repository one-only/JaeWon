package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//회의실 배정 - 풀이 : 제일 빨리끝나는 회의를 우선적으로 선택하면 됨
public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//                return o1[1] - o2[1];
//            }
//        });
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0]; // == return Integer.compare(o1[0], o2[0]);
            }
            return o1[1] - o2[1];
        });
        int count = 1;
        int end_time = arr[0][1];
        for (int i = 1; i < N; i++) {
            //직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(end_time <= arr[i][0]) {
                end_time = arr[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
