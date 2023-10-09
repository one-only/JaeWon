package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//잃어버린 괄호 - 풀이 : -로 나누고 처음부분만 result에 저장하고 나머지부분은 빼준다.
public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String[] sub = br.readLine().split("-");
        for (int i = 0; i < sub.length; i++) {
            int tmp = 0;
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]);
            }
            if(i == 0) {
                result = tmp;
            } else {
                result -= tmp;
            }
        }
        System.out.println(result);
    }
}
