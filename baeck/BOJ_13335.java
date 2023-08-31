package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트럭
public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());//길이
        int L = Integer.parseInt(st.nextToken());//하중

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> bridge = new LinkedList<>();
        for(int w=0; w<W; w++) {
            bridge.offer(0);
        }
        int cnt = 0;
        int sum = 0;
        while(!bridge.isEmpty()) {
            sum -= bridge.poll();
            if(!trucks.isEmpty()) {
                if(sum + trucks.peek() <= L) {
                    int newTruck = trucks.poll();
                    sum += newTruck;
                    bridge.offer(newTruck);
                }else {
                    bridge.offer(0);
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
