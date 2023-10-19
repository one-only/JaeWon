package baeck.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//걸그룹 마스터
public class BOJ_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, List<String>> groupAndName = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine(); // 그룹 이름
            int m = Integer.parseInt(br.readLine()); // 멤버 수
            List<String> members = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                String memberName = br.readLine();
                members.add(memberName);
            }

            Collections.sort(members); // 멤버 이름을 정렬
            groupAndName.put(groupName, members);
        }
        for (int i = 0; i < M; i++) {
            String inputName = br.readLine();
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                List<String> members = groupAndName.get(inputName);
                Collections.sort(members);
                for (String member:
                     members) {
                    System.out.println(member);
                }
            } else {
                for (String groupName :
                        groupAndName.keySet()) {
                    List<String> member = groupAndName.get(groupName);
                    if (member.contains(inputName)) {
                        System.out.println(groupName);
                    }
                }
            }
        }
    }
}
