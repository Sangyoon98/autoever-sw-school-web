package Wrapper클래스;

public class WrapperMain {
    public static void main(String[] args) {
        Age age = new Age();
        age.age = 100;

        System.out.println(age);
    }
}

class Age {
    int age;
}
