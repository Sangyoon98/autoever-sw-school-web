package 추상클래스;

public class SmartPhone extends Phone {
    public SmartPhone(String name) {
        super(name);    // 부모의 생성자 호출
    }

    @Override   // 추상 메서드에 대한 오버라이드
    void call() {
        System.out.println("부모의 요청으로 통화 기능을 완성합니다.");
    }

    public void internet() {
        System.out.println("인터넷을 검색 합니다.");
    }
}
