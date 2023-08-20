package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pwdSearch_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int url = Integer.parseInt(input[0]);
        int needs = Integer.parseInt(input[1]);
        Map<String, String> info = new HashMap<>();
        for (int i = 0; i < url; i++) {
            input = br.readLine().split(" ");
            info.put(input[0], input[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs; i++) {
            sb.append(info.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
