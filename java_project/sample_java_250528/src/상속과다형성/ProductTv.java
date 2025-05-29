package 상속과다형성;

// 상속 : 부모 클래스의 필드와 메서드를 자식 클래스가 물려 받는 것
public class ProductTv extends ProtoType {
    String name;    // 이름
    boolean isInternet; // 인터넷 기능

    public ProductTv(boolean isPower, int channel, int volume, boolean isInternet) {
        super(isPower, channel, volume);    // 부모의 생성자 호출
        this.isInternet = isInternet;
        name = "LG";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("볼륨을 " + volume + "으로 변경 하였습니다.");
        } else System.out.println("볼륨 설정 범위가 아닙니다.");
    }

    @Override   // 오버라이딩 관계 성립 여부를 문법적으로 체크해주는 Annotation
    public void setChannel(int channel) {
        if (channel > 0 && channel < 2000) {
            this.channel = channel;    // 1 ~ 1999
            System.out.println("채널을 " + channel + "으로 변경 하였습니다.");
        } else System.out.println("체널 설정 범위가 아닙니다.");
    }

    // 메서드 오버로딩 : 매개변수의 개수와 타입으로 구분하는 것
    public void setChannel(int channel, boolean isInternet) {
        if (isInternet) {
            this.isInternet = true;
            System.out.println("인터넷 모드입니다.");
        }
        else {
            this.isInternet = false;
            if (channel > 0 && channel < 2000) {
                this.channel = channel;    // 1 ~ 1999
                System.out.println("채널을 " + channel + "으로 변경 하였습니다.");
            } else System.out.println("체널 설정 범위가 아닙니다.");
        }
    }

    public void viewTv() {
        System.out.println("이름 : " + name);
        System.out.println("전원 : " + isPower);
        System.out.println("채널 : " + channel);
        System.out.println("볼륨 : " + volume);
        System.out.println("인터넷 모드 : " + isInternet);
    }
}
