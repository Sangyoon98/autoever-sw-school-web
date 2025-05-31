package 디폴트메소드;

// 필드 : 모든 필드는 자동으로 상수(final static)으로 변환
public interface RemoteControl {
    int MAX_VOLUME = 100;   // 인터페이스 생성 시 한번 생성되고 변경 불가
    int MIN_VOLUME = 0;
    void turnON();  // public abstract가 자동으로 추가
    void turnOFF();
    void setVolume(int volume);

    // 디폴트 메소드 : JDK 8에서 추가, 예외 조항
    default void setMute(boolean mute) {
        if (mute) System.out.println("무음 처리 합니다.");
        else System.out.println("무음 해제 합니다.");
    }

    static void changeBattery() {
        System.out.println("건전지를 교환 합니다.");
    }
}
