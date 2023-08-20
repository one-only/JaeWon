package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class fashion_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String tmp = br.readLine();
                String[] wear = tmp.split(" "); // 첫번째 예시 wear[0] = hat wear[1] = headgear
                if(clothes.containsKey(wear[1])) {
                    int value = clothes.get(wear[1]);
                    clothes.put(wear[1], value + 1); // 이미 존재하면 +1만 해줌
                } else {
                    clothes.put(wear[1], 2); // 존재하지 않으면 2 (경우의 수. 안입을 때, 입을때)
                }
                //clothes.put(wear[1], clothes.getOrDefault(wear[1], 0) + 1); -> 위의 if else 조건문과 같은 코드...
            }
            int answer = 1;
            for (String key: clothes.keySet()){
                answer *= clothes.get(key);
            }
            sb.append(answer - 1).append("\n"); // 마지막에 아무것도 입지않은 경우 제외
        }
        System.out.println(sb);
    }
}
