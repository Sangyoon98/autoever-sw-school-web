package 열거클래스;
// 열거 타입 : 한정된 상수 집합을 정의하는 참조 타입

public class EnumMain {
    public static void main(String[] args) {
        Developer developer = new Developer("곰돌이사육사", DevType.FRONTEND, Career.SENIOR, Gender.MALE);
        developer.devInfo();
    }
}
