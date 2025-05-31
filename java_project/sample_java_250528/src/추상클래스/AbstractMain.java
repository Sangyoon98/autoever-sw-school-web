package 추상클래스;

public class AbstractMain {
    public static void main(String[] args) {
        // 부모 클래스의 참조 변수에 자식 객체를 대입
        Phone phone = new SmartPhone("iPhone 16 Pro");
        phone.setPower(true);
        ((SmartPhone) phone).internet();    // 업캐스팅
        phone.call();

        SmartPhone smartPhone = new SmartPhone("Galaxy S25 Ultra");
        smartPhone.setPower(true);
        smartPhone.internet();
        smartPhone.call();
    }
}
