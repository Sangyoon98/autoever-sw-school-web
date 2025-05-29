package 상속과다형성;

public class ProtoType {
    boolean isPower;    // 전원 ON/OFF
    int channel;        // 채널
    int volume;         // 볼륨

    public ProtoType(boolean isPower, int channel, int volume) {
        this.isPower = isPower;
        this.channel = channel;
        this.volume = volume;
    }

    // setter 역할 : 내부의 인스턴스 값이 정해진 범위에서 설정되도록 해야 함
    public void setChannel(int channel) {
        if (channel > 0 && channel < 1000) this.channel = channel;    // 1 ~ 999
        else System.out.println("체널 설정 범위가 아닙니다.");
    }

    public void setPower(boolean isPower) {
        this.isPower = isPower;
    }
}
