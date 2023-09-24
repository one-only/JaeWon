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
//-------------------설명---------------------------------------------------------
//    int testCase = Integer.parseInt(br.readLine()); 테스트 케이스
//    Map<String, Integer> clothes = new HashMap<>(); 맵 선언
//    int n = Integer.parseInt(br.readLine());
//
//    Map<String, Integer> clothes = new HashMap<>();
//    clothes 의 맵은 아이템 종류를 키값으로 가짐
//        뒤에는 Integer 니까 해당 종류(키)의 아이템 수
//
//        String tmp = br.readLine(); ===== hat headgear
//
//        String[] wear = tmp.split(" "); wear[1] -> headgear : 종류, wear[0] -> 아이템
//
//
//        int value = clothes.get(wear[1]);
//        clothes.put(wear[1], value + 1); // 이미 존재하면 +1만 해줌 이유 : 입을 수 있는 아이템이 하나 늘어난 것
//
//        clothes.put(wear[1], 2); // 존재하지 않으면 2 (경우의 수: 안입을 때, 입을때)
//
//        hat headgear
//        sunglasses eyewear
//        turban headgear
//
//        [hat, null]
//        [sunglasses, null]
//        [turban, null]
//        2 x 2 x 2 인데 여기에서 전부 null 인 경우[null, null, null] 1을 빼줘야 함 그래서 첫번째는 답 5
//
//
//
//
//
//        2                            	testCase
//        3				n
//        hat headgear
//        sunglasses eyewear
//        turban headgear
//        3
//        mask face
//        sunglasses face            //clothes.put(wear[1], value + 1); // 이미 존재하면 +1만 해줌 이유 : 입을 수 있는 아이템이 하나 늘어난 것
//        makeup face