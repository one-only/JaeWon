package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//국영수
public class BOJ_10825 {
    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        @Override
        public int compareTo(Student other) {
            if (this.kor != other.kor) {
                return Integer.compare(other.kor, this.kor); // 국어 점수 내림차순 정렬
            } else if (this.eng != other.eng) {
                return Integer.compare(this.eng, other.eng); // 영어 점수 오름차순 정렬
            } else if (this.math != other.math) {
                return Integer.compare(other.math, this.math); // 수학 점수 내림차순 정렬
            } else {
                return this.name.compareTo(other.name); // 이름 오름차순 정렬
            }
        }
        //Integer.compare(a, b)는 a와 b를 비교하여 결과에 따라 값을 반환합니다.
        //만약 a가 b보다 작다면, 음수 값을 반환합니다
        //만약 a가 b와 같다면, 0을 반환합니다.
        //만약 a가 b보다 크다면, 양수 값을 반환합니다.
    }
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int kor = Integer.parseInt(input[1]);
            int eng = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);
            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.name);
        }

    }
}

//국영수
//입력
//12
//Junkyu 50 60 100
//Sangkeun 80 60 50
//Sunyoung 80 70 100
//Soong 50 60 90
//Haebin 50 60 100
//Kangsoo 60 80 100
//Donghyuk 80 60 100
//Sei 70 70 70
//Wonseob 70 70 90
//Sanghyun 70 70 80
//nsj 80 80 80
//Taewhan 50 60 90