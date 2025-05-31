package 인터페이스;

public class LAN implements NetworkAdapter{
    String company;

    LAN(String company) {
        this.company = company;
    }

    @Override
    public void connect() {
        System.out.println(company + " LAN에 연결 되었습니다.");
    }
}
