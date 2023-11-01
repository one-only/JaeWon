package baeck.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 영어단어 암기는 괴로워
public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> word = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if(key.length() < M) continue;
            // 이미 나온 단어인 경우 카운트 증가, 처음 나온 단어인 경우 1로 설정
            word.put(key, word.getOrDefault(key, 0) + 1);
        }
        List<String> words = new ArrayList<>(word.keySet());

        Collections.sort(words, (o1, o2) -> {
            // 자주 등장하는 단어 순서대로 정렬
            if (Integer.compare(word.get(o1), word.get(o2)) != 0) {
                return Integer.compare(word.get(o2), word.get(o1));
            }
            // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            // 등장 횟수와 길이가 같으면 사전 순으로 정렬
            return o1.compareTo(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String str :
                words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
