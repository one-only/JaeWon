package baeck;

import java.io.*;

//하노이탑 옮기기
public class BOJ_11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = hanoi(N, 1,2, 3, 0, sb);
        bw.write(String.valueOf(count) + "\n");
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static int hanoi(int N, int start, int sub, int to, int count, StringBuilder sb) {
        count++;
        if(N == 1) {//N = 3 일때 1에서 3으로 이동
            sb.append(start + " " + to + "\n");
            return count;
        }
        count = hanoi(N - 1, start, to, sub, count, sb);
        sb.append(start + " " + to + "\n");
        count = hanoi(N - 1, sub, start, to, count, sb);
        return count;
    }
}
