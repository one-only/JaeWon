package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//회사에 있는 사람
public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder str = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        HashMap<String, String> name = new HashMap<>();
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            if(value.equals("enter")) {
                name.put(key, value);
            } else if (value.equals("leave")) {
                if(name.containsKey(key)) name.remove(key);
            }
        }
        ArrayList<String> list = new ArrayList<>(name.keySet());
        Collections.sort(list, Collections.reverseOrder());
        for (String s :
                list) {
            str.append(s).append("\n");
        }
        System.out.print(str);
        br.close();
    }
}
