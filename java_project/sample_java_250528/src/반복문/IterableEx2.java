package 반복문;

// Iterable 객체 순회

import java.util.Scanner;

public class IterableEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i : arr) {
            i += 100;
            System.out.print(i + "/");
        }

        System.out.println();
    }
}
