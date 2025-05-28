package 입출력;

import java.util.Scanner;

// 이름, 주소, 성별, 나이를 입력받아 출력하기

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력 : ");
        String name = sc.next();    // 공백 기준으로 문자열 입력
        sc.nextLine();
        System.out.print("주소 입력 : ");
        String address = sc.nextLine();    // 줄바꿈 문자 기준으로 문자열 입력
        System.out.print("성별 입력 : ");
        char gender = sc.next().charAt(0);    // 줄바꿈 문자 기준으로 문자열 입력
        System.out.print("나이를 입력 하세요 : ");
        int age = sc.nextInt();

        System.out.println("==== 회원 정보 출력 =====");
        System.out.println("이름 : " + name);
        System.out.println("주소 : " + address);
        System.out.println("성별 : " + gender);
        System.out.println("나이 : " + age);
    }
}
