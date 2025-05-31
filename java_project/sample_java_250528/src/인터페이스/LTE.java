package 인터페이스;

public class LTE implements NetworkAdapter {
    String company;

    LTE(String company) {
        this.company = company;
    }

    @Override
    public void connect() {
        System.out.println(company + " LTE에 연결 되었습니다.");
    }
}
