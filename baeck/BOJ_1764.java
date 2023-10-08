package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //Queue<String> q1 = new LinkedList<>(); // 시간초과 이유 : q1.contains() 메서드가 반복문 안에 호출되어 M번 밥ㄴ복될 때 총 O(N*M)의 시간이 걸린다.
        Set<String> set = new HashSet<>();
        ArrayList<String> q2 = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(set.contains(input)) {
                cnt++;
                q2.add(input);
            }
        }
        System.out.println(cnt);
        Collections.sort(q2);

        for (int i = 0; i < q2.size(); i++) {
            System.out.println(q2.get(i));
        }

    }
}
