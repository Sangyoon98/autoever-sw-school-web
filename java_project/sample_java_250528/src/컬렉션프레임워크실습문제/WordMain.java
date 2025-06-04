package 컬렉션프레임워크실습문제;
// 알파벳 소문자로 이루어진 단어 정렬, 길이가 짧은 것, 사전 순, 중복 제거

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class WordMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Set<String> arr = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine().trim());
        }

        for (String s : arr) System.out.println(s);
    }
}
