package 컬렉션프레임워크실습문제;
// 이름과 성적을 입력 받아 성적이 높은 사람 순으로 정렬

import java.util.Scanner;
import java.util.TreeSet;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> arr = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("성적 : ");
            int score = sc.nextInt();
            arr.add(new Student(name, score));
        }

        for (Student student : arr) System.out.println(student);
    }
}

class Student implements Comparable<Student> {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score == o.score) return this.name.compareTo(o.name);
        else if (this.score < o.score) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "이름 : " + name + ", 성적 : " + score;
    }
}
