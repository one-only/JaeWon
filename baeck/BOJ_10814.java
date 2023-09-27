package baeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//나이순 정렬
public class BOJ_10814 {
    static class Person implements Comparable<Person>{
        int age;
        String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person other) {
            if(this.age != other.age) {
                return Integer.compare(this.age, other.age);
            } else return other.name.compareTo(this.name);
        }
    }
    public static void main(String[] args) throws IOException {
        List<Person> personList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            personList.add(new Person(age, name));
        }

        Collections.sort(personList);

        for (Person person :
                personList) {
            System.out.println(person.age + " " + person.name);
        }
    }
}
