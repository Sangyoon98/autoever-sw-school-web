package 입출력;

public class Parent {
    private String name;    // default
    private String money;
    private String addr;

    public Parent() {
        name = "이건희";
        money = "100억";
        addr = "서울시 강남구 삼성동";
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public String getAddr() {
        return addr;
    }
}