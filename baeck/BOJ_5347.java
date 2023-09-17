package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최소공배수 LCM = 두수 곱한거에 최대공약수를 나눔
public class BOJ_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        long a,b;
        int ans;
        for (int i = 1; i <= testCase; i++) {
            String[] str = br.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            System.out.println(a*b/gcd(Math.max(a,b), Math.min(a,b)));
        }

    }
    public static long gcd(long x, long y) {
        long tmp = x % y;
        if(tmp == 0) {
            return y;
        } else {
            return gcd(y, tmp);
        }
    }
}
