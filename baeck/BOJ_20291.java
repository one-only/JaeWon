package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//파일 정리
public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> input = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String[] tmp = temp.split("\\.");
            String extension = tmp[tmp.length - 1];

            if(input.containsKey(extension)) {
                input.put(extension, input.get(extension) + 1);
            } else {
                input.put(extension, 1);
            }
        }
        List<String> keyList = new ArrayList<>(input.keySet());
        Collections.sort(keyList);
        for (String key: keyList){
            System.out.println(key + " " + input.get(key));
        }

    }
}
