package 회원정보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name;
        int age;
        Member.Gender gender;
        Member.Job job;

        System.out.print("이름 : ");
        name = br.readLine();

        // 나이 입력 및 유효성 검사
        while (true) {
            System.out.print("나이 : ");
            String input = br.readLine();
            try {
                age = Integer.parseInt(input);
                if (age < 0 || age > 199) {
                    System.out.println("나이는 0에서 199사이의 값만 입력 가능합니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        }

        // 성별 입력 및 Gender enum 변환
        while (true) {
            System.out.print("성별 (M/F) : ");
            String input = br.readLine().trim().toUpperCase();
            if (input.equals("M")) {
                gender = Member.Gender.MALE;
                break;
            } else if (input.equals("F")) {
                gender = Member.Gender.FEMALE;
                break;
            } else {
                System.out.println("성별을 다시 확인해주세요.");
            }
        }

        // 직업 입력 및 Job enum 변환
        while (true) {
            System.out.print("직업 (1:학생, 2:회사원, 3:주부, 4:무직) : ");
            String input = br.readLine();
            try {
                int jobInput = Integer.parseInt(input);
                if (jobInput >= 1 && jobInput <= 4) {
                    job = Member.Job.values()[jobInput - 1];
                    break;
                } else {
                    System.out.println("1~4 중 선택하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        }

        // Member 객체를 Builder 패턴으로 생성
        Member member = new Member.Builder()
                .name(name)
                .age(age)
                .gender(gender)
                .job(job)
                .build();

        // 멤버 정보 출력
        printMember(member);
    }

    public static void printMember(Member member) {
        System.out.println("======= 회원 정보 =======");
        System.out.println("이름 : " + member.getName());
        System.out.println("나이 : " + member.getAge());
        System.out.println("성별 : " + member.getGender().getDisplayName());
        System.out.println("직업 : " + member.getJob().getDisplayName());
    }
}
